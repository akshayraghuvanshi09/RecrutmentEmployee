package com.recruitmentmodule.serviceimpl;

import java.util.ArrayList;
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
import com.recruitmentmodule.dto.ScheduleJobInterviewRequestDto;
import com.recruitmentmodule.dto.ScheduleJobInterviewResponseDto;
import com.recruitmentmodule.exception.BusinessException;
import com.recruitmentmodule.handler.AddResponse;
import com.recruitmentmodule.handler.CommonResponse;
import com.recruitmentmodule.handler.ResponseMessage;
import com.recruitmentmodule.model.ScheduleJobInterview;
import com.recruitmentmodule.repository.ScheduleJobInterviewRepository;
import com.recruitmentmodule.service.IScheduleJobInterviewService;
import com.recruitmentmodule.utils.Constants;
import com.recruitmentmodule.utils.Messages;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("unchecked")
public class IScheduleJobInterviewServiceImpl<T> implements IScheduleJobInterviewService<T> {

	@Autowired
	private ScheduleJobInterviewRepository jobInterviewRepo;

	@Autowired
	private ModelMapper mapper;
   
	//Schedule Interview of applying candidates for job
	@Override
	public T scheduleInterview(List<ScheduleJobInterviewRequestDto<T>> scheduleJobInterviewRequestDto) {
		log.info("IScheduleJobInterviewServiceImpl :: scheduleInterview == START");

		try {
			@SuppressWarnings("rawtypes")
			List<ScheduleJobInterviewResponseDto> dtos = new ArrayList<ScheduleJobInterviewResponseDto>();

			for (int i = 0; i < scheduleJobInterviewRequestDto.size(); i++) {
				if (scheduleJobInterviewRequestDto.get(i).getCandidate().isEmpty()
						&& scheduleJobInterviewRequestDto.get(i).getInterviewPlace().isEmpty()
						&& scheduleJobInterviewRequestDto.get(i).getJobTitle().isEmpty()
						&& scheduleJobInterviewRequestDto.get(i).getInterviewer().isEmpty()) {
					return (T) new AddResponse(Messages.INVALID_FIELD, Constants.BAD_REQUEST_HTTP_STATUS_CODE);
				} else {
					ScheduleJobInterview addInterview = mapper.map(scheduleJobInterviewRequestDto.get(i),
							ScheduleJobInterview.class);
					@SuppressWarnings("rawtypes")
					ScheduleJobInterviewResponseDto<List> addInterviewResponseDto = mapper
							.map(jobInterviewRepo.save(addInterview), ScheduleJobInterviewResponseDto.class);
					dtos.add(addInterviewResponseDto);
				}
			}
			log.info("IScheduleJobInterviewServiceImpl :: scheduleInterview == END");
			return (T) new CommonResponse(Messages.SUCCESS, Constants.OK, dtos);
		} catch (Exception e) {
			log.info("Exception while in IScheduleJobInterviewServiceImpl in scheduleInterview() : {}", e.getMessage());
			log.info("IScheduleJobInterviewServiceImpl :: scheduleInterview == END");
			return (T) new CommonResponse(Messages.SWW, Constants.ERROR);
		}

	}

	//Fetch all Schedule Interview 
	@Override
	public T getAllScheduleJobInterview(Integer pageNumber, Integer pageSize) {
		log.info("IScheduleJobInterviewServiceImpl :: getAllScheduleJobInterview == START");
		try {

			Pageable p = PageRequest.of(pageNumber, pageSize);
			Page<ScheduleJobInterview> pagePost = jobInterviewRepo.findAll(p);
			List<ScheduleJobInterview> allInterviewer = pagePost.getContent();
			if (allInterviewer.isEmpty()) {
				throw new BusinessException(Constants.OK, Messages.EMPTY_LIST);
			}
			List<ScheduleJobInterviewResponseDto<T>> sDtos = allInterviewer.stream()
					.map(t -> mapper.map(t, ScheduleJobInterviewResponseDto.class)).collect(Collectors.toList());
			@SuppressWarnings("rawtypes")
			GetAllPostResponse PostResponse = new GetAllPostResponse();
			PostResponse.setContent(sDtos);
			PostResponse.setPageNumber(pagePost.getNumber());
			PostResponse.setPageSize(pagePost.getSize());
			PostResponse.setTotalElements(pagePost.getTotalElements());
			PostResponse.setTotalPages(pagePost.getTotalPages());
			PostResponse.setLastPage(pagePost.isLast());
			log.info("IScheduleJobInterviewServiceImpl :: getAllScheduleJobInterview == END");
			return (T) new CommonResponse(Messages.SUCCESS, Constants.OK, PostResponse);
		} catch (BusinessException e) {
			e.printStackTrace();
			log.info("IScheduleJobInterviewServiceImpl :: getAllScheduleJobInterview == END");
			return (T) new ResponseMessage(e.getErrorMessage(), e.getErrorCode());
		}

	}

	//Delete Schedule Interview by id
	@Override
	public T deleteScheduleJobInterview(Integer id) {
		log.info("IScheduleJobInterviewServiceImpl :: deleteScheduleJobInterview == START");
		try {
			Optional<ScheduleJobInterview> optional = jobInterviewRepo.findById(id);
			if (optional.get().getAddInterviewId().equals(id)) {
				jobInterviewRepo.deleteById(id);
				log.info("IScheduleJobInterviewServiceImpl :: deleteScheduleJobInterview == END");
				return (T) new ResponseMessage(Messages.POST_DELETED_WITH_ID + id, Constants.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception :: IScheduleJobInterviewServiceImpl :: deleteScheduleJobInterview : {}", e.getMessage());
			log.info("IScheduleJobInterviewServiceImpl :: deleteScheduleJobInterview == END");
			return (T) new ResponseMessage("Id not Found !" + id, Constants.NOT_FOUND);
		}
		return (T) new ResponseMessage(Messages.SWW, Constants.BAD_REQUEST_HTTP_STATUS_CODE);

	}

	//Search Interview by keyword
	@Override
	public T searchInterview(String keyword) {
		log.info("IScheduleJobInterviewServiceImpl :: searchInterview == START");
		List<ScheduleJobInterview> search = jobInterviewRepo.search(keyword);
		List<ScheduleJobInterviewResponseDto<T>> candidates = search.stream()
				.map(t -> mapper.map(t, ScheduleJobInterviewResponseDto.class)).collect(Collectors.toList());
		log.info("IScheduleJobInterviewServiceImpl :: searchInterview == END");
		return (T) candidates;
	}
}
