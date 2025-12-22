package com.spring_boot_circuit_breaker_with_resilience4j_retry.service;

import java.util.Random;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	private int attempt = 0;

	@Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
	public String processPayment() {

		if (new Random().nextBoolean()) {

			attempt++;

			System.out.println("Attempt: " + attempt);

			throw new RuntimeException("Temporary failure");

		}

		return "Hello from service";
	}

	@Recover
	public String recover(RuntimeException ex) {

		System.out.println("Recovery method called");

		return "Payment service is currently unavailable";

	}
}
