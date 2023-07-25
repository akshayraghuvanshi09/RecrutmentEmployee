package com.recruitmentmodule.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "add_interview")
public class AddInterview {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "add_interview_id")
	private Integer addInterviewId;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "candidate")
	private String candidate;

	@Column(name = "interview_place")
	private String interviewPlace;

	@Column(name = "interview_date")
	private Date interviewDate;

	@Column(name = "interview_time")
	private Time interviewTime;

	@Column(name = "interviewer")
	private String interviewer;

	@Column(name = "description")
	private String description;

}
