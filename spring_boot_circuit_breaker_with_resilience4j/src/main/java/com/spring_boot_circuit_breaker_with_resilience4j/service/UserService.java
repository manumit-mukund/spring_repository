package com.spring_boot_circuit_breaker_with_resilience4j.service;

import org.springframework.stereotype.Service;

import com.spring_boot_circuit_breaker_with_resilience4j.exception.ServiceFailureException;

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

	public String fallback(Exception ex) {

		return "Fallback response: Service is temporarily unavailable";

	}

}
