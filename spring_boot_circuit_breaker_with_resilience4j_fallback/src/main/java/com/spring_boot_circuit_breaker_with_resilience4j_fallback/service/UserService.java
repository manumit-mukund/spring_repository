package com.spring_boot_circuit_breaker_with_resilience4j_fallback.service;

import org.springframework.stereotype.Service;

import com.spring_boot_circuit_breaker_with_resilience4j_fallback.exception.ServiceFailureException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserService {

	@CircuitBreaker(name = "userService", fallbackMethod = "fallback")
	public String getUser() {

		// Simulate failure
		if (Math.random() > 0.5) {

			throw new ServiceFailureException("Service failed");

		}

		return "User data fetched successfully";
	}

	public String fallback(ServiceFailureException ex) {

		return "Fallback response:" + ex.getMessage();

	}

	// If we use this method, we'll get java.lang.NoSuchMethodException: class
	// java.lang.String class
	// com.spring_boot_circuit_breaker_with_resilience4j_fallback.service.UserService.fallback(,class
	// java.lang.Throwable) on the Console.
	// Also, the message in the browser will be displayed from the ControllerAdvice
	public String fallback() {

		return "Fallback response: fallback() called";

	}

}
