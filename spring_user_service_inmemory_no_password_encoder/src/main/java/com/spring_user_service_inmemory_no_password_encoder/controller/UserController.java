package com.spring_user_service_inmemory_no_password_encoder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/hello")
	public String hello() {

		return "Hello World for user!";
	}

}
