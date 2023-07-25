package com.recruitmentmodule.dto;

import java.util.List;

import com.recruitmentmodule.model.JobCandidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class JobPostRequestDto {
	
	private Integer addJobId;
	
	private String company;

	private String jobTitle;

	private String jobType;
	
	private String jobCategory;
	
	private Integer noOfVacancy;
	
	private String dateOfClosing;
	
	private String gender;

	private String minExperience;

	private String isFeatured;

	private String status;
	
	private String shortDescription;

	private String longDescription;
		
}
