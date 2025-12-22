package com.spring_boot_circuit_breaker_with_hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_hystrix.service.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService myService;

	@GetMapping("/hello")
	public String hello() {

		return myService.sayHello();

		// Test url: http://localhost:9001/hello

	}
}