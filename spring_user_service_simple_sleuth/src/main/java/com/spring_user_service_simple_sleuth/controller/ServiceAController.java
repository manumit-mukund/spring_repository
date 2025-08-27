package com.spring_user_service_simple_sleuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceAController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/callServiceB")
	public String callServiceB() {

		return restTemplate.getForObject("http://localhost:9001/serviceB", String.class);

	}
}