package com.spring_user_service_simple_log_using_lombok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ExampleController {

	@GetMapping("/test")
	public String testLogging() {

		log.info("testLogging(): An info message");

		try {

			// Simulate an error
			log.debug("testLogging(): A debug message");
			throw new RuntimeException("Test exception");

		} catch (RuntimeException e) {

			// Log at different levels
			log.warn("testLogging(): A warning message", e);
			log.error("testLogging(): An error message", e);
			throw e;

		}
	}

}
