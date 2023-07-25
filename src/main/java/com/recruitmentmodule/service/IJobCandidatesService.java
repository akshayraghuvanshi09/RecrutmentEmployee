package com.recruitmentmodule.service;

import org.springframework.web.multipart.MultipartFile;

public interface IJobCandidatesService<T> {

	T saveCandidates(MultipartFile file,String candidateData);
	
	T getAllCandidate(Integer pageNumber, Integer pageSize);
	
	T deleteCandidatesById(Integer id);
	
	T getAllCandidateNameAndId();
	
	T searchCandidate(String keyword);
	
	T getAllJobTitle();
	
	T getAllSelectedCandidate(String title);
}
