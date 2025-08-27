package com.spring_user_service_simple_sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

	private static final Logger logger = LoggerFactory.getLogger(ServiceBController.class);

	@GetMapping("/serviceB")
	public String serviceB() {

		logger.info("Inside Service B");

		return "Response from Service B";

	}
}