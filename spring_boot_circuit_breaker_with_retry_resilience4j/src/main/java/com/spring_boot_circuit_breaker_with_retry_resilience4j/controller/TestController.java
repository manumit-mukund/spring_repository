package com.spring_boot_circuit_breaker_with_retry_resilience4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_retry_resilience4j.service.BackendService;

@RestController
@RequestMapping("/api")
public class TestController {

	private final BackendService backendService;

	public TestController(BackendService backendService) {

		this.backendService = backendService;

	}

	@GetMapping("/test")
	public String test() {

		return backendService.callExternalService();
		
		//Test url: http://localhost:9001/api/test

	}
}
