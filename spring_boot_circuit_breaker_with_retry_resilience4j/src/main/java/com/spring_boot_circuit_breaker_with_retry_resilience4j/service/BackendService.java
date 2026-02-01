package com.spring_boot_circuit_breaker_with_retry_resilience4j.service;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.spring_boot_circuit_breaker_with_retry_resilience4j.exception.ServiceFailureException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class BackendService {

	private static final String SERVICE_NAME = "externalService";
	private int attempt = 0;

	@Retry(name = SERVICE_NAME, fallbackMethod = "retryFallback")
	@CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "circuitBreakerFallback")
	public String callExternalService() {

		// Simulate random failure
		if (new Random().nextBoolean()) {

			attempt++;

			System.out.println("Attempt: " + attempt + "\n");

			throw new ServiceFailureException("Service failed");
		}

		attempt = 0;

		return "Success response from backend";
	}

	// Fallback method for Retry (if all retries fail)
	public String retryFallback(HttpServerErrorException e) {

		System.out.println("--- All retries failed. Executing Retry Fallback. ---");

		attempt = 0;

		return "Fallback response from Retry: Service is currently unavailable due to transient failures.";
	}

	// Fallback method for Circuit Breaker (if the circuit is open)
	public String circuitBreakerFallback(Throwable t) {

		System.out.println("--- Circuit is open. Executing Circuit Breaker Fallback.");

		attempt = 0;

		return "Fallback response from Circuit Breaker: Service is down, circuit is open.";
	}
}
