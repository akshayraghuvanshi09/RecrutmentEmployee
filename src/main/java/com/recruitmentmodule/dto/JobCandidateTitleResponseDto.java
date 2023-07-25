package com.recruitmentmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobCandidateTitleResponseDto {
	
	private Integer jobCandidateId;
	
	private String jobTitle;
}
