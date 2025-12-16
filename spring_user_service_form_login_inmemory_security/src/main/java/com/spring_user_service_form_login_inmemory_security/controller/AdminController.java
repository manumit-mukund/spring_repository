package com.spring_user_service_form_login_inmemory_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_user_service_form_login_inmemory_security.model.User;
import com.spring_user_service_form_login_inmemory_security.service.UserService;

@RestController
@RequestMapping("/admin/users")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@Autowired
	private UserService userService;

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return userService.getUser(username);

		// Test url: http://localhost:9001/admin/users/abc
	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		return userService.getAllUsers();

		// Test url: http://localhost:9001/admin/users/getall
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {

		return userService.addUser(user);

	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable("username") String username) {

		/*
		 * This snippet will also work but not needed as we are using exception handling
		 * User existingUser = userService.getUser(username);
		 * 
		 * if (existingUser == null) {
		 * 
		 * throw new ResourceNotFoundException("Resource with" + username +
		 * "not found.");
		 * 
		 * }
		 */

		User deleteddUser = userService.deleteUser(username);

		return ResponseEntity.ok(deleteddUser);

		// Postman DELETE url: http://localhost:9001/users/delete/abc

	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello World for admin!";
	}

}
