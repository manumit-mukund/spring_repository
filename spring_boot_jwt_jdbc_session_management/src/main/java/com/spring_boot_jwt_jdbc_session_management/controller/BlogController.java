package com.spring_boot_jwt_jdbc_session_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/blog")
public class BlogController {

	@GetMapping("/unrestricted")
	public ResponseEntity<?> getMessage() {
		return new ResponseEntity<>("Hai this is a normal message..", HttpStatus.OK);
	}

	@GetMapping("/restricted")
	public ResponseEntity<?> getRestrictedMessage() {
		return new ResponseEntity<>("This is a restricted message", HttpStatus.OK);
	}
}