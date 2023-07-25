package com.recruitmentmodule.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recruitmentmodule.serviceimpl.IJobCandidatesServiceImpl;
import com.recruitmentmodule.serviceimpl.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class JobCandidateRestController<T> {

	@Autowired
	private IJobCandidatesServiceImpl<T> candidatesService;

	@Autowired
	private ReportService resservice;

	private static final Logger log = LoggerFactory.getLogger(JobCandidateRestController.class);

	// save candidates
	@PostMapping("/saveCandidate")
	public T saveCandidate(@RequestPart("file") MultipartFile file,
			@RequestParam("candidateData") String candidateData) {
		log.info("file:{}", file.getOriginalFilename());
		log.info("candidatae:{}", candidateData);
		return (T) candidatesService.saveCandidates(file, candidateData);
	}

	// get all candidates
	@GetMapping("/getCandidates")
	public T getAllCandidates(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return (T) candidatesService.getAllCandidate(pageNumber, pageSize);
	}

	// delete candidate by id
	@DeleteMapping("/deleteCandidateById/{id}")
	public T deleteCandidateById(@PathVariable Integer id) {
		return (T) candidatesService.deleteCandidatesById(id);
	}

	// get candidate name and id
	@GetMapping("/getCandidateNameAndId")
	public T getCandidateNameAndId() {
		return (T) candidatesService.getAllCandidateNameAndId();
	}

	// get candidates pdf report
	@GetMapping("/jobCandidatePdfReport")
	public String jobCandidatePdfReport() throws FileNotFoundException, JRException {
		return resservice.jobCandidatePdfReport();
	}

	// get candidates CSV report
	@GetMapping("/jobCandidateCSVreport")
	public void jobCandidateCSVReport(HttpServletResponse response) throws IOException {
		resservice.jobCandidateCSVReport(response);
	}

	// search
	@GetMapping("/jobCandidate/searchCandidate/{keyword}")
	public T search(@PathVariable("keyword") String keyword) {
		T result = candidatesService.searchCandidate(keyword);
		return (T) result;

	}

	// get all job title
	@GetMapping("/getAllJobTitle")
	public T getAllJobTitle() {
		return candidatesService.getAllJobTitle();
	}

	// get job all candidates with matching job title
	@GetMapping("/getAllSelectedCandidate/{title}")
	public T getAllSelectedCandidate(@PathVariable String title) {
		return candidatesService.getAllSelectedCandidate(title);
	}
}
