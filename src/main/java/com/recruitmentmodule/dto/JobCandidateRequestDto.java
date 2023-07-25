package com.recruitmentmodule.dto;

import java.util.Date;

import com.recruitmentmodule.model.JobPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobCandidateRequestDto {

	private Integer jobCandidateId;

	private String candidateName;

	private String fb;

	private String linkedin;

	private String email;

	private String status;

	private Date applyDate;

	private JobPost jobPost;
	
	private String phoneNumber;
}
