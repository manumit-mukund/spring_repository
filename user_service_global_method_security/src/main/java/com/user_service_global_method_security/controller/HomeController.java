package com.user_service_global_method_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

	@GetMapping("/home")
	public String home() {

		return "This is a home page.";

	}

	@GetMapping("/register")
	public String register() {

		return "This is a register page.";

	}

}