package com.recruitmentmodule.service;

import java.util.List;

import com.recruitmentmodule.dto.JobPostRequestDto;

public interface IAddJobService<T> {

	T saveJobPost(JobPostRequestDto jobPostDto);

	T getAllPost(Integer pageNumber, Integer pageSize);

	T deleteAllPost();

	T deletePostById(Integer id);

	T deleteSelectedPost(List<Integer> ids);

	T updatePostById(Integer id, JobPostRequestDto jobPostDto);

	T search(String keyword);

}
