package com.spring_boot_api_version_media_type.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping(value = "/users", produces = "application/vnd.app-v1+json")
	public String getUsersV1() {

		return "Users API Version 1";

		// Test url: Postman: http://localhost:9001/api/users
		// Headers:
		// key: Accept
		// value: application/vnd.app-v1+json

	}

	@GetMapping(value = "/users", produces = "application/vnd.app-v2+json")
	public String getUsersV2() {

		return "Users API Version 2";

		// Test url: Postman: http://localhost:9001/api/users
		// Headers:
		// key: Accept
		// value: application/vnd.app-v2+json

	}
}