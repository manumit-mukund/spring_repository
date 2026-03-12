package com.spring_boot_api_version_header.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping(value = "/users", headers = "X-API-VERSION=1")
	public String getUsersV1() {

		return "Users API Version 1";

		// Postman Test url: http://localhost:9001/api/users
		// Headers info:
		// key: X-API-VERSION
		// value: 1

	}

	@GetMapping(value = "/users", headers = "X-API-VERSION=2")
	public String getUsersV2() {

		return "Users API Version 2";

		// Postman Test url: http://localhost:9001/api/users
		// Headers info:
		// key: X-API-VERSION
		// value: 2

	}
}