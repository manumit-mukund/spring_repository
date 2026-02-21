package com.spring_boot_circuit_breaker_with_retry_resilience4j.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceFailureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceFailureException(String message) {

		super(message);

	}
}