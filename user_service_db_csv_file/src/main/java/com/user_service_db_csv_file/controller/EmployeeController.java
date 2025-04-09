package com.user_service_db_csv_file.controller;

//import java.awt.PageAttributes.MediaType;
//import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service_db_csv_file.component.CsvGeneratorUtil;
import com.user_service_db_csv_file.entity.Employee;
import com.user_service_db_csv_file.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CsvGeneratorUtil csvGeneratorUtil;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/csv")
	public ResponseEntity<byte[]> generateCsvFile() {

		List<Employee> employees = employeeRepository.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "employees.csv");

		byte[] csvBytes = csvGeneratorUtil.generateCsv(employees).getBytes();

		return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
	}
}