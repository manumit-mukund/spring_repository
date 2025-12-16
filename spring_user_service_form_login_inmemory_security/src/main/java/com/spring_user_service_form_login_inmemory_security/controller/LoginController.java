package com.spring_user_service_form_login_inmemory_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {

		return "login.html";

	}

	@GetMapping("/access-denied-error")
	public String accessDenied() {
		
		return "access-denied"; // Name of your HTML/JSP template
		
	}

}
