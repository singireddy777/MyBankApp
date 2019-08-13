package com.hcl.bankmanagementapp.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> allExceptionHandler(Exception exception,WebRequest request)
	{
		ErrorResponse response = new ErrorResponse(exception.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
