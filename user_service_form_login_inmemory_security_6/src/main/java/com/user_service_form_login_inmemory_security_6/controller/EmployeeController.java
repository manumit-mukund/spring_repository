package com.user_service_form_login_inmemory_security_6.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

	@GetMapping("/getall")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String getAllEmployees() {

		return "You Received All Employees List";

	}

	@PostMapping("/save")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String saveEmployees() {

		return "You saved a Employee";

	}

	@PutMapping("/update")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updateEmployees() {

		return "You updated a Employee";

	}

}