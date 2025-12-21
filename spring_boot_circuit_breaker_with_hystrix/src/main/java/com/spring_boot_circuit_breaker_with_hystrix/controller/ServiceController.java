package com.spring_boot_circuit_breaker_with_hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_hystrix.service.RemoteService;

@RestController
public class ServiceController {

	@Autowired
	private RemoteService remoteService;

	@GetMapping("/service")
	public String callService() {

		try {

			return remoteService.callService();

		} catch (InterruptedException e) {

			return "Failed to call service";

		}

		// Test url: http://localhost:9001/service
	}
}