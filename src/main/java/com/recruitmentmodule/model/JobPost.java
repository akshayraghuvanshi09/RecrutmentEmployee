package com.recruitmentmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "add_job_post")
public class JobPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_post_id")
	private Integer addJobId;
	
	@Column(name = "company_name")
	private String company;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "job_type")
	private String jobType;
	
	
	@Column(name = "job_category")
	private String jobCategory;
	
	@Column(name = "no_of_vacancy")
	private Integer noOfVacancy;
	
	@Column(name = "date_of_closing")
	private String dateOfClosing;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "min_experience")
	private String minExperience;
	
	@Column(name = "is_featured")
	private String isFeatured;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "short_desc")
	private String shortDescription;
	
	@Column(name = "long_desc")
	private String longDescription;
	
	 
}
