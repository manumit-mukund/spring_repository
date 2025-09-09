package com.spring_boot_trace_propagation_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class OtherController {

	@GetMapping("/other")
	public ResponseEntity<String> sayHello(HttpServletRequest request) {

		log.info("traceparent: {}", request.getHeader("traceparent"));
		log.info("Someone called the /other endpoint");

		return ResponseEntity.ok("other");

	}
}
