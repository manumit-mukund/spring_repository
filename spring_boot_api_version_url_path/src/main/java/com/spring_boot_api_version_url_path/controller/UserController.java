package com.spring_boot_api_version_url_path.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping("/v1/users")
	public String getUsersV1() {

		return "Users API Version 1";

		// test url: http://localhost:9001/api/v1/users
	}

	@GetMapping("/v2/users")
	public String getUsersV2() {

		return "Users API Version 2";

		// Test url: http://localhost:9001/api/v2/users
	}
}