package com.spring_user_service_simple_log_using_lombok.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Global exception handler for all controllers
public class GlobalExceptionHandler {

	// Method to handle IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {

		// Return a custom error message with HTTP 400 status
		return new ResponseEntity<>("handleIllegalArgumentException Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

	// Method to handle generic exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {

		// Return a custom error message with HTTP 500 status
		return new ResponseEntity<>("handleGeneralException error: " + ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
}