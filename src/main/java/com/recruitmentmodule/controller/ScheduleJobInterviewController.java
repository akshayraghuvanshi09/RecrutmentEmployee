package com.recruitmentmodule.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recruitmentmodule.dto.ScheduleJobInterviewRequestDto;
import com.recruitmentmodule.service.IScheduleJobInterviewService;
import com.recruitmentmodule.serviceimpl.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class ScheduleJobInterviewController<T> {

	@Autowired
	private IScheduleJobInterviewService<T> scheduleJobInterviewService;

	@Autowired
	private ReportService reportService;

	// save sechedule job interview
	@PostMapping("/scheduleJobInterview")
	public T scheduleJobInterview(@RequestBody List<ScheduleJobInterviewRequestDto<T>> scheduleJobInterviewRequestDto) {
		return (T) scheduleJobInterviewService
				.scheduleInterview((List<ScheduleJobInterviewRequestDto<T>>) scheduleJobInterviewRequestDto);
	}

	// get all schedule job interview
	@GetMapping("/getAllInterview")
	public T getAllScheduleJobInterview(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return (T) scheduleJobInterviewService.getAllScheduleJobInterview(pageNumber, pageSize);
	}

	// delete schedule interview by id
	@DeleteMapping("/deleteInterviewById/{id}")
	public T deleteCandidateById(@PathVariable Integer id) {
		return (T) scheduleJobInterviewService.deleteScheduleJobInterview(id);
	}

	// search schedule interview
	@GetMapping("scheduleInterview/searchInterview/{keyword}")
	public T search(@PathVariable("keyword") String keyword) {
		T result = scheduleJobInterviewService.searchInterview(keyword);
		return (T) result;

	}

	// get schedule pdf report
	@GetMapping("/interviewPdfReport")
	public String InterviewPdfReport() throws FileNotFoundException, JRException {
		return reportService.ScheduleInterviewPdfReport();
	}

	// get schedule CSV report
	@GetMapping("/interviewCSVreport")
	public void InterviewCSVReport(HttpServletResponse response) throws IOException {
		reportService.ScheduleInterviewCSVReport(response);
	}

}
