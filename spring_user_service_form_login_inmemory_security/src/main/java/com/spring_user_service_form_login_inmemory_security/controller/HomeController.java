package com.spring_user_service_form_login_inmemory_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

	@GetMapping("/home")
	public String home() {

		return "This is a home page.";

		// Test url: http://localhost:9001/public/home

	}

	@GetMapping("/register")
	public String register() {

		return "This is a register page.";

	}

}
