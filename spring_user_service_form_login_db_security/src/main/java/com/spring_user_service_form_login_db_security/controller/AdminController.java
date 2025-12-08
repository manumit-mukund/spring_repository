package com.spring_user_service_form_login_db_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_user_service_form_login_db_security.model.User;
import com.spring_user_service_form_login_db_security.service.UserServiceImpl;

@RestController
@RequestMapping("/admin/users")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@Autowired
	private UserServiceImpl userUserServiceImpl;

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return userUserServiceImpl.getUser(username);
		
		//Test url: http://localhost:9001/admin/users/abc
	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		return userUserServiceImpl.getAllUsers();
		
		//Test url: http://localhost:9001/admin/users/getall
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
