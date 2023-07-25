package com.recruitmentmodule.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_candidate")
public class JobCandidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_candidate_id")
	private Integer jobCandidateId;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "candidate_name")
	private String candidateName;

	@Column(name = "fb")
	private String fb;

	@Column(name = "linkedin")
	private String linkedin;

	@Column(name = "email")
	private String email;

	@Column(name = "cv_url")
	private String cvUrl;

	@Column(name = "status")
	private String status;

	@Column(name = "apply_date")
	private Date applyDate;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "address")
	private String Address;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@ManyToOne
	@JoinColumn(name = "job_Post_fk")
	private JobPost jobPost;
	
	
}
