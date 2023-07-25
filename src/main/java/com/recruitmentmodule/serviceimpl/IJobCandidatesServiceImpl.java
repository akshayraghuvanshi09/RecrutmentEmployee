package com.recruitmentmodule.serviceimpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitmentmodule.dto.GetAllPostResponse;
import com.recruitmentmodule.dto.JobCandidateIdAndNameResponseDto;
import com.recruitmentmodule.dto.JobCandidateNameResponseDto;
import com.recruitmentmodule.dto.JobCandidateRequestDto;
import com.recruitmentmodule.dto.JobCandidateResponseDto;
import com.recruitmentmodule.dto.JobCandidateTitleResponseDto;
import com.recruitmentmodule.exception.BusinessException;
import com.recruitmentmodule.handler.AddResponse;
import com.recruitmentmodule.handler.CommonResponse;
import com.recruitmentmodule.handler.ResponseMessage;
import com.recruitmentmodule.model.JobCandidate;
import com.recruitmentmodule.repository.JobCandidatesRepository;
import com.recruitmentmodule.repository.JobPostRepository;
import com.recruitmentmodule.service.IJobCandidatesService;
import com.recruitmentmodule.utils.Constants;
import com.recruitmentmodule.utils.Messages;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("unchecked")
public class IJobCandidatesServiceImpl<T> implements IJobCandidatesService<T> {

	@Autowired
	private JobCandidatesRepository candidatesRepo;

	@Autowired
	private JobPostRepository jobPostRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ObjectMapper objectMapper;

	// Save Candidates That Apply for job
	@Override
	public T saveCandidates(MultipartFile file, String candidateData) {
		log.info("IJobCandidatesServiceImpl :: saveCandidates == START");
		// converting String into JSON
		log.info("AssetCategoryServiceImpl :: addAssetCategory == converting String into JSON");
		JobCandidateRequestDto candidateDto = null;
		try {
			candidateDto = objectMapper.readValue(candidateData, JobCandidateRequestDto.class);
			System.out.println(candidateData);
			JobCandidate candidate = mapper.map(candidateDto, JobCandidate.class);

			if (candidate.getCandidateName().isEmpty() || candidate.getEmail().isEmpty()
					|| candidate.getPhoneNumber().isEmpty()) {
				return (T) new ResponseMessage(Messages.NULL_REQUEST, Constants.ERROR);
			} else if (!candidate.getPhoneNumber().matches("(0/91)?[7-9][0-9]{9}")) {
				return (T) new ResponseMessage(Messages.INVALID_MOBILE_NUM, Constants.ERROR);
			} else if (!candidate.getEmail().matches("^(.+)@(.+)$")) {
				return (T) new ResponseMessage(Messages.INVALID_EMAIL, Constants.ERROR);
			} else if (file.isEmpty()) {
				return (T) new ResponseMessage(Messages.FILE_NOT_FOUNF, Constants.ERROR);
			}
			// processing and uploading file
			log.info("AssetCategoryServiceImpl :: addAssetCategory == processing and uploading file");
			if (!file.getContentType().equalsIgnoreCase(Constants.PDF_FILE_EXTENSION_NAME)) {
				// if file is not PDF
				return (T) new AddResponse(file.getOriginalFilename() + " should has .pdf extension only", 405);

			} else {
				// upload file to folder and update the name to contact
				log.info(
						"AssetCategoryServiceImpl :: addAssetCategory == upload file to folder and update the name to contact");
				Path path = Paths.get("src\\main\\resources\\static\\cv" + File.separator + file.getOriginalFilename());
				System.out.println(path);
				candidate.setCvUrl(path.toString());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			}

			Integer addJobId = candidate.getJobPost().getAddJobId();
			String title = jobPostRepo.findById(addJobId).get().getJobTitle();
			log.info("AssetCategoryServiceImpl :: addAssetCategory == JobTitle : {}", title);
			candidate.setApplyDate(new Date());
			log.info("IJobCandidatesServiceImpl :: saveCandidates == END");
			return (T) mapper.map(candidatesRepo.save(candidate), JobCandidateResponseDto.class);

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  saveCandidates : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: saveCandidates == END");
			return (T) new CommonResponse(Messages.SWW, Constants.ERROR);
		}

	}

	// Fetch All Candidates That Apply For job
	@Override
	public T getAllCandidate(Integer pageNumber, Integer pageSize) {
		log.info("IJobCandidatesServiceImpl :: getAllCandidate == START");
		try {
			Pageable p = PageRequest.of(pageNumber, pageSize);
			Page<JobCandidate> pagePost = candidatesRepo.findAll(p);
			List<JobCandidate> allCandidates = pagePost.getContent();
			if (allCandidates.isEmpty()) {
				throw new BusinessException(Constants.OK, Messages.EMPTY_LIST);
			}
			List<JobCandidateResponseDto> jobPostDtoList = allCandidates.stream()
					.map(t -> mapper.map(t, JobCandidateResponseDto.class)).collect(Collectors.toList());

			@SuppressWarnings("rawtypes")
			GetAllPostResponse PostResponse = new GetAllPostResponse();
			PostResponse.setContent(jobPostDtoList);
			PostResponse.setPageNumber(pagePost.getNumber());
			PostResponse.setPageSize(pagePost.getSize());
			PostResponse.setTotalElements(pagePost.getTotalElements());
			PostResponse.setTotalPages(pagePost.getTotalPages());
			PostResponse.setLastPage(pagePost.isLast());
			log.info("IJobCandidatesServiceImpl :: getAllCandidate == END");
			return (T) new CommonResponse(Messages.SUCCESS, Constants.OK, PostResponse);
		} catch (BusinessException e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  getAllCandidate : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: getAllCandidate == END");
			return (T) new ResponseMessage(e.getErrorMessage(), e.getErrorCode());
		}
	}

	// Delete Candidate By Id that Apply For Job
	@Override
	public T deleteCandidatesById(Integer id) {
		log.info("IJobCandidatesServiceImpl :: deleteCandidatesById == START");
		try {
			Optional<JobCandidate> optional = candidatesRepo.findById(id);
			if (optional.get().getJobCandidateId().equals(id)) {
				candidatesRepo.deleteById(id);
				return (T) new ResponseMessage(Messages.POST_DELETED_WITH_ID + id, Constants.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  deleteCandidatesById : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: deleteCandidatesById == END");
			return (T) new ResponseMessage("Id not Found !" + id, Constants.NOT_FOUND);
		}
		log.info("IJobCandidatesServiceImpl :: deleteCandidatesById == END");
		return (T) new ResponseMessage(Messages.SWW, Constants.BAD_REQUEST_HTTP_STATUS_CODE);

	}

	// Fetch All Candidate Name and Id
	@Override
	public T getAllCandidateNameAndId() {
		log.info("IJobCandidatesServiceImpl :: getAllCandidateNameAndId == START");
		List<JobCandidate> jobCandidates = candidatesRepo.findAll();
		try {
			if (jobCandidates.isEmpty()) {
				log.info("IJobCandidatesServiceImpl :: getAllCandidateNameAndId == List is completely empty : {} ",
						jobCandidates);
				throw new BusinessException(Constants.OK,Messages.EMPTY_LIST);
			} else {
				List<JobCandidateIdAndNameResponseDto> candidates = jobCandidates.stream()
						.map(t -> mapper.map(t, JobCandidateIdAndNameResponseDto.class)).collect(Collectors.toList());
				log.info("IJobCandidatesServiceImpl :: getAllCandidateNameAndId == List Of Candidates : {} ",
						candidates);
				log.info("IJobCandidatesServiceImpl :: deleteCandidatesById == END");
				return (T) candidates;
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  getAllCandidateNameAndId : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: getAllCandidateNameAndId == END");
			return (T) new ResponseMessage(e.getErrorMessage(), e.getErrorCode());
		}

	}

	// Search Candidate By Keyword
	@Override
	public T searchCandidate(String keyword) {
		log.info("IJobCandidatesServiceImpl :: searchCandidate == START");
		List<JobCandidate> search = candidatesRepo.search(keyword);
		List<JobCandidateResponseDto> candidates = search.stream()
				.map(t -> mapper.map(t, JobCandidateResponseDto.class)).collect(Collectors.toList());
		log.info("IJobCandidatesServiceImpl :: searchCandidate == END");
		return (T) candidates;
	}

	// Fetch All Job Title
	@Override
	public T getAllJobTitle() {
		log.info("IJobCandidatesServiceImpl :: getAllJobTitle == START");
		try {
			List<JobCandidate> candidates = candidatesRepo.findAll();
			if (candidates.isEmpty()) {
				throw new BusinessException(Constants.OK, Messages.EMPTY_LIST);
			}
			System.out.println(candidates);
			List<JobCandidateTitleResponseDto> collect = candidates.stream()
					.map(t -> mapper.map(t, JobCandidateTitleResponseDto.class)).collect(Collectors.toList());
			log.info("IJobCandidatesServiceImpl :: getAllJobTitle == List Of Job Title : {} ", collect);
			log.info("IJobCandidatesServiceImpl :: getAllJobTitle == END");
			return (T) collect;
		} catch (BusinessException e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  getAllJobTitle : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: getAllJobTitle == END");
			return (T) new ResponseMessage(e.getErrorMessage(), e.getErrorCode());

		}

	}

	// Fetch All Candidates According To Title
	@Override
	public T getAllSelectedCandidate(String title) {
		log.info("IJobCandidatesServiceImpl :: getAllSelectedCandidate == START");
		try {
			log.info("IJobCandidatesServiceImpl :: getAllSelectedCandidate == Title : {} ", title);
			System.out.println(title);
			List<JobCandidate> candidates = candidatesRepo.findAll();
			if (candidates.isEmpty()) {
				throw new BusinessException(Constants.OK,Messages.EMPTY_LIST);
			}
			System.out.println(candidates);
			List<JobCandidateNameResponseDto> collect = candidates.stream()
					.map(t -> mapper.map(t, JobCandidateNameResponseDto.class)).collect(Collectors.toList());
			System.out.println(collect);
			List<JobCandidateNameResponseDto> list = new ArrayList<>();
			for (JobCandidate jobCandidate : candidates) {
				if (title.equals(jobCandidate.getJobTitle())) {
					JobCandidateNameResponseDto responseDto = mapper.map(jobCandidate,
							JobCandidateNameResponseDto.class);
					list.add(responseDto);
				}
			}
			log.info("IJobCandidatesServiceImpl :: getAllSelectedCandidate == END");
			return (T) list;
		} catch (BusinessException e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  getAllSelectedCandidate : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: getAllSelectedCandidate == END");
			return (T) new ResponseMessage(e.getErrorMessage(), e.getErrorCode());
		}

	}

}
