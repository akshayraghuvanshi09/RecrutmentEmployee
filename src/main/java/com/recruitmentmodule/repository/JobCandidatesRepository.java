package com.recruitmentmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitmentmodule.model.JobCandidate;

public interface JobCandidatesRepository extends JpaRepository<JobCandidate, Integer> {
	@Query("SELECT p FROM JobCandidate p WHERE CONCAT(p.jobTitle, p.candidateName, p.email, p.status,p.applyDate) LIKE %?1%")
	List<JobCandidate> search(String keyword);

}
