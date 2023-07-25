package com.recruitmentmodule.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

	private String message;
	private Integer statusCode;
	private Object data;
	
	public CommonResponse(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	

}
