package com.user_service_simple_http_patch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service_simple_http_patch.model.User;
import com.user_service_simple_http_patch.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userUserServiceImpl;

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return userUserServiceImpl.getUser(username);
	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		return userUserServiceImpl.getAllUsers();
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {

		return userUserServiceImpl.addUser(user);

	}

	@PatchMapping("/update/{username}")
	public ResponseEntity<User> updateUserEmail(@PathVariable("username") String username, @RequestBody String email) {

		User updatedUser = userUserServiceImpl.updateUserEmail(username, email);

		return ResponseEntity.ok(updatedUser);

		// Postman PATCH url: http://localhost:9001/users/update/abc
		// Postman Body: abc1@yahoo.com

	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello World!";
	}

}
