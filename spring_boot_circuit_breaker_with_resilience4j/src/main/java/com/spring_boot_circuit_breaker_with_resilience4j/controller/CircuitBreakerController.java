package com.spring_boot_circuit_breaker_with_resilience4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_resilience4j.service.ExternalService;

@RestController
public class CircuitBreakerController {

	@Autowired
	private ExternalService service;

	@GetMapping("/test-service")
	public String testCircuitBreaker() {

		return service.retrieveDataFromExternalService();

	}
}
