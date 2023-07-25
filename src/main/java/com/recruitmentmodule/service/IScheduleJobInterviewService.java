package com.recruitmentmodule.service;

import java.util.List;

import com.recruitmentmodule.dto.ScheduleJobInterviewRequestDto;

public interface IScheduleJobInterviewService<T> {

	T scheduleInterview(List<ScheduleJobInterviewRequestDto<T>> scheduleJobInterviewRequestDto);

	T getAllScheduleJobInterview(Integer pageNumber, Integer pageSize);

	T deleteScheduleJobInterview(Integer id);

	T searchInterview(String keyword);

}
