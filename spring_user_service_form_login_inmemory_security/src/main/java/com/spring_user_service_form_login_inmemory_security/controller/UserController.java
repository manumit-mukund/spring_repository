package com.spring_user_service_form_login_inmemory_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
//@PreAuthorize("hasAnyRole('ADMIN', 'USER')") //It's optional as we're already using it in MySecurityConfig
public class UserController {

	@GetMapping("/hello")
	public String hello() {

		return "Hello World for user!";

		// Test url: http://localhost:9001/user/hello
	}

}
