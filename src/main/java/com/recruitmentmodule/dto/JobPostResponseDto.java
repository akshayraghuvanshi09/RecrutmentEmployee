package com.recruitmentmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobPostResponseDto {

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
