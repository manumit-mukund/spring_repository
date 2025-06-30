package com.user_service_simple_log_elastic_logstash_kibana.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.user_service_simple_log_elastic_logstash_kibana.exception.ResourceNotFoundException;

@ControllerAdvice // Global exception handler for all controllers
public class GlobalExceptionHandler {

	// Method to handle IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {

		// Return a custom error message with HTTP 400 status
		return new ResponseEntity<>("handleIllegalArgumentException: " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		// Test url: http://localhost:9001/api/test2/-2

	}

	// Method to handle generic exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {

		// Return a custom error message with HTTP 500 status
		return new ResponseEntity<>("handleGeneralException: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		// Test url: http://localhost:9001/api/test

	}

	@ExceptionHandler(MissingPathVariableException.class)
	public ResponseEntity<Map<String, String>> handleMissingPathVariableException(MissingPathVariableException ex) {

		Map<String, String> error = new HashMap<>();

		error.put("error", "Missing path variable exception");
		error.put("message", "Required path variable is missing in this request. Please add it to your request.");

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		// Test url: http://localhost:9001/users/
	}

	// handling a custom ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	// @ResponseStatus(HttpStatus.NOT_FOUND) //This is optional.
	public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {

		Map<String, String> error = new HashMap<>();

		error.put("error", "Resource not found");
		error.put("message", ex.getMessage()); // Use exception message

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		// Test url: http://localhost:9001/users/abc1

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	// @ResponseStatus(HttpStatus.NOT_FOUND) //This is optional.
	public ResponseEntity<Map<String, String>> handleNoHandlerFoundException(NoHandlerFoundException ex) {

		Map<String, String> error = new HashMap<>();

		error.put("error", "No handler found xception");
		error.put("message",
				"Requested resource wasn't found on the server: " + ex.getHttpMethod() + " " + ex.getRequestURL());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		// http://localhost:9001/users
		// Test url: http://localhost:9001/api/test

	}
}