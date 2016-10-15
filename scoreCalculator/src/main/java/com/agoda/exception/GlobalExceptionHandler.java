package com.agoda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleException(ValidationException e){
		ErrorResponse error = createErrorResponse(e);
		error.setErrorCode("VALIDATION_ERROR");
		error.setErrorMessage(e.getMessage());
		
		return error;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleException(Exception e){
		ErrorResponse error = createErrorResponse(e);
		error.setErrorMessage("Error Occured while perofroming operation, Please contact administrator.`");
		
		return error;
	}
	
	private ErrorResponse createErrorResponse(Exception e){
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("SYSTEM_ERROR");
		error.setErrorMessage(e.getMessage());
		error.setDeveloperErrorMessage(e.getMessage());
		
		return error;
	}
}
