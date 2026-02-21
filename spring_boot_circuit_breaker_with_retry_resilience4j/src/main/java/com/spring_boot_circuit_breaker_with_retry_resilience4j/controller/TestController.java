package com.spring_boot_circuit_breaker_with_retry_resilience4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_retry_resilience4j.service.ExternalApiService;

@RestController
@RequestMapping
public class TestController {

	private final ExternalApiService externalService;

	public TestController(ExternalApiService externalService) {

		this.externalService = externalService;

	}

	@GetMapping("/test")
	public String test() {

		return externalService.fetchDataFromExternalApi();

	}
}