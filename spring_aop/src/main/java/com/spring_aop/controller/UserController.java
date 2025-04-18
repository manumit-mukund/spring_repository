package com.spring_aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/getall")
	public String getAllUsers() {

		return "Hello, users for Spring AOP...";
	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello, World!";
	}

	@GetMapping("/hi")
	public String hi() {

		return "Hi, World!";
	}

}
