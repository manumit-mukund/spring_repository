package com.spring_user_service_simple_globalexception.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice // Global exception handler for all controllers
public class GlobalExceptionHandler {

	// Method to handle IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {

		// Return a custom error message with HTTP 400 status
		return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

	// Example of handling a custom ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {

		Map<String, String> error = new HashMap<>();
		error.put("error", "Resource not found");
		error.put("message", ex.getMessage()); // Use exception message

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	// Example of handling a custom ResourceNotFoundException
	@ExceptionHandler(InvalidUserException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, String>> handleInvalidUserException(InvalidUserException ex) {

		Map<String, String> error = new HashMap<>();
		error.put("error", "Invalid user");
		error.put("message", ex.getMessage()); // Use exception message

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	// Method to handle generic exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {

		// Return a custom error message with HTTP 500 status
		return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
}