package com.spring_boot_trace_propagation_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_trace_propagation_service.service.HelloWorldService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class HelloWorldController {

	private final HelloWorldService helloWorldService;

	public HelloWorldController(HelloWorldService helloWorldService) {

		this.helloWorldService = helloWorldService;

	}

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {

		log.info("Someone called the /hello endpoint");

		return ResponseEntity.ok(helloWorldService.sayHello());

	}

	@GetMapping("/bad-call")
	public void badCall() {

		log.info("Someone called the /bad-call endpoint");

		helloWorldService.fakeBadCall();

	}
}
