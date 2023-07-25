package com.recruitmentmodule.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobCandidateResponseDto {

	private String jobTitle;

	private String candidateName;

	private String fb;

	private String linkedin;

	private String email;

	private String cvUrl;

	private String status;

	private Date applyDate;

}
