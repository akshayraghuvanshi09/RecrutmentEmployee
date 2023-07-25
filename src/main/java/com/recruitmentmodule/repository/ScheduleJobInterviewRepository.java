package com.recruitmentmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recruitmentmodule.model.ScheduleJobInterview;

@Repository
public interface ScheduleJobInterviewRepository extends JpaRepository<ScheduleJobInterview, Integer> {
	@Query("SELECT p FROM ScheduleJobInterview p WHERE CONCAT(p.jobTitle, p.candidate, p.interviewPlace, p.interviewDate,p.interviewer) LIKE %?1%")
	List<ScheduleJobInterview> search(String keyword);
}
