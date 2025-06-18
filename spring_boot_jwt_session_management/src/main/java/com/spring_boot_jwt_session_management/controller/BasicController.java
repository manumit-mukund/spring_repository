package com.spring_boot_jwt_session_management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {

	@RequestMapping({ "/home" })
	public String home() {
		return "Welcome to home";
	}
}
