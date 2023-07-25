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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recruitmentmodule.dto.JobPostRequestDto;
import com.recruitmentmodule.serviceimpl.IAddJobServiceImpl;
import com.recruitmentmodule.serviceimpl.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class JobPostRestController<T> {

	@Autowired
	private IAddJobServiceImpl<T> service;
	
	@Autowired
	private ReportService resservice;

	// get all job posts
	@GetMapping("/getAllPost")
	public T getAllPosts(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber
			,@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		T allPost = service.getAllPost(pageNumber,pageSize);
		return allPost;
	}

	// save job post
	@PostMapping("/savePost")
	public T saveJobPost(@RequestBody JobPostRequestDto jobPostDto) {
		return service.saveJobPost(jobPostDto);
	}

	// delete all job posts
	@DeleteMapping("/deleteAllPost")
	public T deleteAllJobPost() {
		return service.deleteAllPost();
	}

	// delete job post by id
	@DeleteMapping("/deletePostById/{id}")
	public T deletePostById(@PathVariable("id") Integer id) {
		return service.deletePostById(id);
	}

	// update job post by id
	@PutMapping("/updatePostById/{id}")
	public T updatePostById(@PathVariable("id") Integer id, @RequestBody JobPostRequestDto jobPostDto) {
		return service.updatePostById(id, jobPostDto);
	}

	// delete post by List of ids
	@DeleteMapping("/deleteSelectedPosts")
	public T deleteSelectedPosts(@RequestParam("ids") List<Integer> ids) {
		return service.deleteSelectedPost(ids);
	}

	// search
	@GetMapping("jobPost/searchPost/{keyword}")
	public T search(@PathVariable("keyword") String keyword) {
		T result = service.search(keyword);
		return (T) result;

	}
	
	//get jobPost pdf report
	@GetMapping("/jobPostPdfReport")
	public String genrateReport() throws FileNotFoundException, JRException {
		return	resservice.jobPostPdfReport();
	}
	
	//get jobpost csv report
	@GetMapping("/jobPostCSVReport")
	public void genrateCSVReport(HttpServletResponse response) throws IOException {
		resservice.jobPostCSVReport(response);
	}

}
