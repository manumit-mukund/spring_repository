package com.user_service_inmemory_bcrypt_password_encoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service_inmemory_bcrypt_password_encoder.model.User;
import com.user_service_inmemory_bcrypt_password_encoder.service.UserServiceImpl;

@RestController
@RequestMapping("/admin/users")
public class AdminController {

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

	@GetMapping("/hello")
	public String hello() {

		return "Hello World for admin!";
	}

}
