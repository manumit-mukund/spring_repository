package com.spring_boot_circuit_breaker_with_retry.service;

import java.util.Random;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.spring_boot_circuit_breaker_with_retry.exception.ServiceFailureException;

@Service
public class PaymentService {

	private int attempt = 0;

	@Retryable(retryFor = { ServiceFailureException.class }, 
			maxAttempts = 2, 
			backoff = @Backoff(delay = 3000))
	public String processPayment() {

		if (new Random().nextBoolean()) {

			if (attempt == 2)
				attempt = 0;

			attempt++;

			System.out.println("Attempt: " + attempt + "\n");

			throw new ServiceFailureException("Temporary failure");

		}

		attempt = 0;

		return "Hello from Payment service";
	}

	@Recover
	public String recover(ServiceFailureException ex) {

		System.out.println("Recovery method called....\n");

		return "Payment service is currently unavailable";

	}
}
