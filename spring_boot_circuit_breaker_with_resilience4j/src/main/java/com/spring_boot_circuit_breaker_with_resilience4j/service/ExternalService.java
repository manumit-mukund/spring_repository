package com.spring_boot_circuit_breaker_with_resilience4j.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {

	private final RestTemplate restTemplate = new RestTemplate();
	private static final String SERVICE_NAME = "externalService";

	@CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "fallbackRetrieveData")
	public String retrieveDataFromExternalService() {

		// Simulate a call to an external service that might fail
		// e.g., return restTemplate.getForObject("http://external-api/data",
		// String.class);

		// Example simulation of failure:
		if (Math.random() < 0.7) { // 70% chance of failure

			throw new RuntimeException("Service is down!");

		}
		return "Success: Data from external service.";
	}

	// Fallback method must have the same signature as the original method, plus a
	// Throwable parameter
	public String fallbackRetrieveData(Throwable throwable) {

		return "Fallback: Data retrieved from cache or default response. Reason: " + throwable.getMessage();

	}
}
