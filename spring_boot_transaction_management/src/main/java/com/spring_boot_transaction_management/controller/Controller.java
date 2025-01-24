package com.spring_boot_transaction_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_transaction_management.entity.Employee;
import com.spring_boot_transaction_management.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class Controller {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws Exception {

		Employee employeeSavedToDB = this.employeeService.addEmployee(employee);

		return new ResponseEntity<Employee>(employeeSavedToDB, HttpStatus.CREATED);

	}
}
