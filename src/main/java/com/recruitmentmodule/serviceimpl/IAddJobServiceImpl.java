package com.recruitmentmodule.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.recruitmentmodule.dto.GetAllPostResponse;
import com.recruitmentmodule.dto.JobPostRequestDto;
import com.recruitmentmodule.dto.JobPostResponseDto;
import com.recruitmentmodule.exception.BusinessException;
import com.recruitmentmodule.handler.CommonResponse;
import com.recruitmentmodule.handler.ResponseMessage;
import com.recruitmentmodule.model.JobPost;
import com.recruitmentmodule.repository.JobPostRepository;
import com.recruitmentmodule.service.IAddJobService;
import com.recruitmentmodule.utils.Constants;
import com.recruitmentmodule.utils.Messages;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("unchecked")
public class IAddJobServiceImpl<T> implements IAddJobService<T> {

	@Autowired
	private JobPostRepository jobPostRepo;

	@Autowired
	private ModelMapper mapper;

	// Save Job Post (By HR)
	@Override
	public T saveJobPost(JobPostRequestDto jobPostDto) {
		log.info("IJobCandidatesServiceImpl :: saveJobPost == START");
		try {
			if (jobPostDto.getJobType().isEmpty() || jobPostDto.getGender().isEmpty()
					|| jobPostDto.getMinExperience().isEmpty() || jobPostDto.getIsFeatured().isEmpty()
					|| jobPostDto.getStatus().isEmpty()) {
				return (T) new ResponseMessage(Messages.INVALID_SELECTION, Constants.ERROR);
			} else if (jobPostDto.getJobTitle().trim().isEmpty()) {
				return (T) new ResponseMessage(Messages.INVALID_TITLE, Constants.ERROR);
			} else if (jobPostDto.getCompany().isEmpty()) {
				jobPostDto.setCompany(Messages.SETCOMPANY_NAME);
			} else if (jobPostDto.getNoOfVacancy() == null) {
				jobPostDto.setNoOfVacancy(Messages.SET_VACANCY);
			} else if (jobPostDto.getShortDescription().trim().isEmpty()) {
				jobPostDto.setShortDescription(Messages.SET_SHORT_DESCRIPTION);
			} else if (jobPostDto.getLongDescription().trim().isEmpty()) {
				jobPostDto.setLongDescription(Messages.SET_LONG_DESCRIPTION);
			}
			JobPost post = mapper.map(jobPostDto, JobPost.class);
			JobPostResponseDto savePost = mapper.map(jobPostRepo.save(post), JobPostResponseDto.class);
			log.info("IJobCandidatesServiceImpl :: saveJobPost == END");
			return (T) new CommonResponse(Messages.SUCCESS, Constants.OK, savePost);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  saveJobPost : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: saveJobPost == END");
			return (T) new CommonResponse(Messages.SWW, Constants.ERROR);
		}

	}

	// Fetch All Job Posts
	@Override
	public T getAllPost(Integer pageNumber, Integer pageSize) {
		log.info("IJobCandidatesServiceImpl :: getAllPost == START");
		try {

			Pageable p = PageRequest.of(pageNumber, pageSize);
			Page<JobPost> pagePost = jobPostRepo.findAll(p);
			List<JobPost> allPosts = pagePost.getContent();
			if (allPosts.isEmpty()) {
				throw new BusinessException(Constants.OK,Messages.EMPTY_LIST);
			}
			List<JobPostRequestDto> jobPostDtoList = allPosts.stream().map(t -> mapper.map(t, JobPostRequestDto.class))
					.collect(Collectors.toList());
			log.info("IJobCandidatesServiceImpl :: getAllCandidateNameAndId == getAllPost : {} ", jobPostDtoList);
			@SuppressWarnings("rawtypes")
			GetAllPostResponse PostResponse = new GetAllPostResponse();
			PostResponse.setContent(jobPostDtoList);
			PostResponse.setPageNumber(pagePost.getNumber());
			PostResponse.setPageSize(pagePost.getSize());
			PostResponse.setTotalElements(pagePost.getTotalElements());
			PostResponse.setTotalPages(pagePost.getTotalPages());
			PostResponse.setLastPage(pagePost.isLast());
			log.info("IJobCandidatesServiceImpl :: getAllPost == END");
			return (T) new CommonResponse(Messages.SUCCESS, Constants.OK, PostResponse);
		} catch (BusinessException e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  getAllPost : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: getAllPost == END");
			return (T) new CommonResponse(e.getErrorMessage(), e.getErrorCode());
		}
	}

	// Delete All Job Posts
	@Override
	public T deleteAllPost() {
		log.info("IJobCandidatesServiceImpl :: deleteAllPost == START");
		try {
			if (!jobPostRepo.findAll().isEmpty()) {
				jobPostRepo.deleteAll();
				log.info("IJobCandidatesServiceImpl :: deleteAllPost == All Post Is Deleted");
				log.info("IJobCandidatesServiceImpl :: deleteAllPost == END");
				return (T) new ResponseMessage(Messages.DATA_DELETE, Constants.OK);
			}
			log.info("IJobCandidatesServiceImpl :: deleteAllPost == END");
			return (T) new ResponseMessage(Messages.DATA_NOT_FOUND, Constants.BAD_REQUEST_HTTP_STATUS_CODE);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  getAllPost : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: getAllPost == END");
			return (T) new CommonResponse(Messages.SWW, Constants.ERROR);

		}

	}

	// Delete Selected JobPost Posted By HR
	@Override
	public T deleteSelectedPost(List<Integer> id) {
		log.info("IJobCandidatesServiceImpl :: deleteAllPost == START");
		try {
			List<JobPost> findAllById = jobPostRepo.findAllById(id);
			System.out.println(id.isEmpty());
			if (!id.isEmpty()) {
				throw new BusinessException(Constants.NOT_FOUND, Messages.SELECT_POST);
			} else {
				for (JobPost post : findAllById) {
					jobPostRepo.delete(post);
				}
				log.info("IJobCandidatesServiceImpl :: deleteAllPost == END");
				return (T) new ResponseMessage(Messages.SELECTED_DATA_DELETED, Constants.OK);
			}
		} catch (BusinessException e) {
			log.info("Exception :: IJobCandidatesServiceImpl ::  deleteSelectedPost : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: deleteSelectedPost == END");
			return (T) new ResponseMessage(e.getErrorMessage(), e.getErrorCode());
		}
	}

	// Delete Job Post By Id
	@Override
	public T deletePostById(Integer id) {
		log.info("IJobCandidatesServiceImpl :: deleteAllPost == START");
		try {
			Optional<JobPost> optional = jobPostRepo.findById(id);
			if (optional.get().getAddJobId().equals(id)) {
				jobPostRepo.deleteById(id);
				return (T) new ResponseMessage(Messages.POST_DELETED_WITH_ID + id, Constants.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception :: IJobCandidatesServiceImpl ::  deletePostById : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: deleteAllPost == END");
			return (T) new ResponseMessage(Messages.ID_NOT_FOUND + id, Constants.NOT_FOUND);
		}
		log.info("IJobCandidatesServiceImpl :: deleteAllPost == END");
		return (T) new ResponseMessage(Messages.SWW, Constants.BAD_REQUEST_HTTP_STATUS_CODE);

	}

	// Update Job Post
	@Override
	public T updatePostById(Integer id, JobPostRequestDto jobPostDto) {
		log.info("IJobCandidatesServiceImpl :: updatePostById == START");
		try {
			Optional<JobPost> findById = jobPostRepo.findById(id);
			JobPost jobPost = findById.get();
			if (jobPost.getAddJobId().equals(id)) {
				JobPost jobPost2 = mapper.map(jobPostDto, JobPost.class);
				JobPostResponseDto dto = mapper.map(jobPost2, JobPostResponseDto.class);
				jobPost2.setAddJobId(jobPost.getAddJobId());
				jobPostRepo.save(jobPost2);
				return (T) new CommonResponse(Messages.SUCCESS, Constants.OK, dto);
			}
		} catch (Exception e) {
			log.info("Exception :: IJobCandidatesServiceImpl ::  updatePostById : {} ", e.getMessage());
			log.info("IJobCandidatesServiceImpl :: updatePostById == END");
			return (T) new ResponseMessage(e.getMessage(), Constants.BAD_REQUEST_HTTP_STATUS_CODE);
		}
		log.info("IJobCandidatesServiceImpl :: updatePostById == END");
		return (T) new ResponseMessage(Messages.BAD_REQUEST, Constants.BAD_REQUEST_HTTP_STATUS_CODE);

	}

	// Search
	@Override
	public T search(String keyword) {
		log.info("IJobCandidatesServiceImpl :: search == START");
		List<JobPost> search = jobPostRepo.search(keyword);
		List<JobPostRequestDto> postDtos = search.stream().map(t -> mapper.map(t, JobPostRequestDto.class))
				.collect(Collectors.toList());
		log.info("IJobCandidatesServiceImpl :: search == END");
		return (T) postDtos;
	}
}
