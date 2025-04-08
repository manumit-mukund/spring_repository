package com.user_service_form_login_inmemory_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service_form_login_inmemory_security.model.User;
import com.user_service_form_login_inmemory_security.service.UserService;

@RestController
@RequestMapping("/admin/users")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

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

		return "Hello World for admin!";
	}

}
