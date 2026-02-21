package com.spring_boot_circuit_breaker_with_retry_resilience4j.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.spring_boot_circuit_breaker_with_retry_resilience4j.exception.ServiceFailureException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ExternalApiService {

	// private final RestTemplate restTemplate = new RestTemplate();
	// A counter to simulate failures for demonstration
	private int attempt = 0;

	@Retry(name = "externalService", fallbackMethod = "retryFallback")
	@CircuitBreaker(name = "externalService", fallbackMethod = "circuitBreakerFallback")
	public String fetchDataFromExternalApi() {

//		attempt++;
//		System.out.println("Attempt number: " + attempt + " - Making API call...");
//
//		// Simulate a failure (e.g., external service is down)
//		if (attempt <= 3) {
//			throw new RuntimeException("Service is down");
//		}
//
//		return restTemplate.getForObject("http://localhost:8080/api/data", String.class);

		if (new Random().nextBoolean()) {

			attempt++;

			System.out.println("Attempt: " + attempt + "\n");

			throw new ServiceFailureException("Service failed");
		}

		attempt = 0;

		return "Success response from backend";
	}

	// Fallback method for the @Retry annotation (triggered if all retries fail)
	public String retryFallback(Throwable t) {

		System.out.println("--- All retries failed. Executing retryFallback. ---");

		return "Fallback response from Retry: Service is temporarily unavailable.";

	}

	// Fallback method for the @CircuitBreaker annotation
	// This will be called immediately if the circuit is OPEN, bypassing all retries
	public String circuitBreakerFallback(Throwable t) {

		System.out.println("--- Circuit is open. Executing circuitBreakerFallback. ---");

		attempt = 0;

		return "Fallback response from CircuitBreaker: The circuit is open to prevent overloading the service.";

	}
}
