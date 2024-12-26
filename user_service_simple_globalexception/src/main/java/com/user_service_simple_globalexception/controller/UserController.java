package com.user_service_simple_globalexception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service_simple_globalexception.model.User;
import com.user_service_simple_globalexception.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userUserServiceImpl;

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		if (username.equals("null") || username.strip().equals("")) {

			throw new IllegalArgumentException("Invalid username: " + username);

		}

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

	@GetMapping("/hello")
	public String hello() {

		return "Hello World!";
	}

}
