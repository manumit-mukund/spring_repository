package com.user_service_global_method_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user")	
	public String methodUser() {

		return "This method is for user.";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")	
	public String methodAdmin() {

		return "This method is for admin.";
	}

}
