package com.agoda.exception;

public class ErrorResponse {

	private String errorCode;
	private String errorMessage;
	private String developerErrorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDeveloperErrorMessage() {
		return developerErrorMessage;
	}
	public void setDeveloperErrorMessage(String developerErrorMessage) {
		this.developerErrorMessage = developerErrorMessage;
	}
	
	
}
