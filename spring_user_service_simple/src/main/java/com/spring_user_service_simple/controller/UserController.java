package com.spring_user_service_simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_user_service_simple.model.User;
import com.spring_user_service_simple.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userUserService;

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return userUserService.getUser(username);

//		Test url (positive): http://localhost:9001/users/abc
//		Test url (positive): http://localhost:9001/users/abc1
	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		return userUserService.getAllUsers();
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {

		if (user.getUsername() == null || user.getUsername().isEmpty()) {

			throw new IllegalArgumentException("Invalid username: " + user.getUsername());

		}

		return userUserService.addUser(user);

//		Test url: http://localhost:9001/users/add
//		Input data:
//			
//		{
//
//		    "username": "pqr" ,
//		    "password": "pqr" ,
//		    "email": "pqr@yahoo.com" 
//
//		}

	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello World!";
	}

}
