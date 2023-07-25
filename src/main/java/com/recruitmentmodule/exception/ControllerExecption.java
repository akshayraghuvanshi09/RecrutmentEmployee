package com.recruitmentmodule.exception;

public class ControllerExecption extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String errorMessage;

	public ControllerExecption() {

	}

	public ControllerExecption(Integer code, String errorMessage) {
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
