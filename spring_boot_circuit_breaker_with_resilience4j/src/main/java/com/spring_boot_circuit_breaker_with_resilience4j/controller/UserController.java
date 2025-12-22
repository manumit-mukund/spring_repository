package com.spring_boot_circuit_breaker_with_resilience4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_resilience4j.service.UserService;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;

	}

	@GetMapping("/user")
	public String getUser() {

		return userService.getUser();

	}
	
	//Test url: http://localhost:9001/user
	
	//Actuator url: http://localhost:9001/actuator/health
}
