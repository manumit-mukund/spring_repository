package com.spring_boot_circuit_breaker_with_resilience4j_retry.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	// @ResponseStatus(HttpStatus.NOT_FOUND) //Optional
	public ResponseEntity<Map<String, String>> handleNoHandlerFoundException(NoHandlerFoundException ex) {

		Map<String, String> error = new HashMap<>();
		error.put("error", "No handler found");
		error.put("message", "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	// Example of handling a custom ServiceFailureException
	@ExceptionHandler(ServiceFailureException.class)
	// @ResponseStatus(HttpStatus.NOT_FOUND) //Optional
	public ResponseEntity<Map<String, String>> handleServiceFailureException(ServiceFailureException ex) {

		Map<String, String> error = new HashMap<>();
		error.put("error", "Service not available");
		error.put("message", ex.getMessage()); // Use exception message

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	// Method to handle IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {

		Map<String, String> error = new HashMap<>();
		error.put("error", "IllegalArgument");
		error.put("message", ex.getMessage()); // Use exception message

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
