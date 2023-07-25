package com.recruitmentmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitmentmodule.model.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
	@Query("SELECT p FROM JobPost p WHERE CONCAT(p.company, p.jobCategory, p.jobTitle, p.dateOfClosing) LIKE %?1%")
	List<JobPost> search(String keyword);
}
