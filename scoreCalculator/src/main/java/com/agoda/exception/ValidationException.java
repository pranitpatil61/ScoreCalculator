package com.agoda.exception;

public class ValidationException extends RuntimeException{

	private String message;
	
	public ValidationException(String message, String devMessage) {
		super(message);
		this.message = devMessage;
	}
	
}
