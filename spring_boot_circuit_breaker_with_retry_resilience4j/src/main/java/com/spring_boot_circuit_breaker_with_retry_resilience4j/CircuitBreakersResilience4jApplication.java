package com.spring_boot_circuit_breaker_with_retry_resilience4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class CircuitBreakersResilience4jApplication {

	public static void main(String[] args) {

		SpringApplication.run(CircuitBreakersResilience4jApplication.class, args);

	}

}