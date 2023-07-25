package com.recruitmentmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCandidateIdAndNameResponseDto {
	private Integer jobCandidateId;

	private String candidateName;

}
