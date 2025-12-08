package com.spring_user_service_form_login_db_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class UserController {

	@GetMapping("/hello")
	public String hello() {

		return "Hello World for user!";
		
		//Test url: http://localhost:9001/user/hello
	}

}
