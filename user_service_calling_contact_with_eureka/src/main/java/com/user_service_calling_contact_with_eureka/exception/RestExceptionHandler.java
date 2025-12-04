package com.user_service_calling_contact_with_eureka.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, String>> handleNoHandlerFoundException(NoHandlerFoundException ex) {

		Map<String, String> error = new HashMap<>();
		error.put("error", "No handler found");
		error.put("message", "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

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

	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<String> handleRestClientException(RestClientException ex) {

		return new ResponseEntity<>("Error communicating with external service: " + ex.getMessage(),
				HttpStatus.SERVICE_UNAVAILABLE);
	}
}
