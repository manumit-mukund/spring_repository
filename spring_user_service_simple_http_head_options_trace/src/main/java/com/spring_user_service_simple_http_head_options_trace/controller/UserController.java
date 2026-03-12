package com.spring_user_service_simple_http_head_options_trace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring_user_service_simple_http_head_options_trace.model.User;
import com.spring_user_service_simple_http_head_options_trace.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return userService.getUser(username);

		// Test url: http://localhost:9001/users/abc
	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		return userService.getAllUsers();

		// Test url: http://localhost:9001/users/getall
	}

	@RequestMapping(value = "/resource/head", method = RequestMethod.HEAD)
	public ResponseEntity<Void> handleHead() {

		return ResponseEntity
				.ok()
				.header("Custom-Header", "SampleValue")
				.header("X-Resource-Version", "1.0")
				.build();

		// Postman HEAD url: http://localhost:9001/users/resource/head

	}

	@RequestMapping(value = "/resource/options", method = RequestMethod.OPTIONS)
	public ResponseEntity<Void> handleOptions() {

		return ResponseEntity
				.ok()
				.header("Allow", "GET, POST, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Authorization").build();

		// Postman OPTIONS url: http://localhost:9001/users/resource/options
	}

	@RequestMapping(value = "/resource/trace", method = RequestMethod.TRACE)
	public ResponseEntity<String> handleTrace(HttpServletRequest request) {

		StringBuilder builder = new StringBuilder();

		builder
		.append(request.getMethod())
		.append("getMethod : ")
		.append(request.getRequestURI())
		.append("getRequestURI : ")
		.append(request.getProtocol()).append("\n");

		request
		.getHeaderNames()
		.asIterator()
		.forEachRemaining(
				header -> builder.append(header).append(" : ").append(request.getHeader(header)).append("\n"));

		return ResponseEntity
				.ok(builder.toString());

		// Postman TRACE url: http://localhost:9001/users/resource/trace
	}

}
