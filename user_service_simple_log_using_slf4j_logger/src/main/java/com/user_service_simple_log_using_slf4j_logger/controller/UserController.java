package com.user_service_simple_log_using_slf4j_logger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service_simple_log_using_slf4j_logger.model.User;
import com.user_service_simple_log_using_slf4j_logger.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userUserService;

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return userUserService.getUser(username);
	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		return userUserService.getAllUsers();
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {

		return userUserService.addUser(user);

	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello World!";
	}

}
