package com.recruitmentmodule.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	private String errorMessage;

	public BusinessException(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BusinessException() {
		super();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
