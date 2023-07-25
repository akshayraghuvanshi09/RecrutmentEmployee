package com.recruitmentmodule.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
	
	private String returnMessage;
	private int returnCode;
}
