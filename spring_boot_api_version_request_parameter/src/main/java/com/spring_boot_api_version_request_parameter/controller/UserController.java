package com.spring_boot_api_version_request_parameter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping(value = "/users", params = "version=1")
	public String getUsersV1() {

		return "Users API Version 1";

		// Test url: http://localhost:9001/api/users?version=1

	}

	@GetMapping(value = "/users", params = "version=2")
	public String getUsersV2() {

		return "Users API Version 2";

		// Test url: http://localhost:9001/api/users?version=2

	}
}