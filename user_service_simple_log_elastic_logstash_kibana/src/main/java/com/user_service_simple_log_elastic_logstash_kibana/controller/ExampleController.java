package com.user_service_simple_log_elastic_logstash_kibana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ExampleController {

	@GetMapping("/test1")
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

	@GetMapping("/test2/{number}")
	public String testIllegalArgumentException(@PathVariable("number") int number) {

		log.info("testIllegalArgumentException(): An info message");

		try {

			// Simulate an error
			log.debug("testIllegalArgumentException(): A debug message, number = " + number);

			if (number <= 0) {
				
				throw new IllegalArgumentException("number must be positive: -> " + number);
				
			}
			return "Fetching number: " + number;

		} catch (RuntimeException e) {

			// Log at different levels
			log.warn("testIllegalArgumentException(): A warning message", e);
			log.error("testIllegalArgumentException(): An error message", e);
			throw e;

		}
	}

}
