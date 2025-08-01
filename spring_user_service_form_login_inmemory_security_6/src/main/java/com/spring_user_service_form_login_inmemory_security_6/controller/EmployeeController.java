package com.spring_user_service_form_login_inmemory_security_6.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

	@GetMapping("/getall")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String getAllEmployees() {

		return "You Received All Employees List";

		// Test url: http://localhost:9001/api/v1/employees/getall

	}

	@PostMapping("/save")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String saveEmployees() {

		return "You saved a Employee";

		// Test url in Postman: http://localhost:9001/api/v1/employees/save

	}

	@PutMapping("/update")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updateEmployees() {

		return "You updated a Employee";

		// Test url in Postman: http://localhost:9001/api/v1/employees/update

	}

}