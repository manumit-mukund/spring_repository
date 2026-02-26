package com.spring_user_service_simple_http_head_options_trace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring_user_service_simple_http_head_options_trace.model.User;
import com.spring_user_service_simple_http_head_options_trace.service.UserService;

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
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
        
     // Postman OPTIONS url: http://localhost:9001/users/resource/options
    }

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {

		return userService.addUser(user);

		/*
		 * Postman PUT url: http://localhost:9001/users/add
		 * 
		 * Postman Body:
		 * 
		 * {
		 * 
		 * "username": "pqr" , "password": "pqr" , "email": "pqr@yahoo.com"
		 * 
		 * }
		 * 
		 */

	}

	@PutMapping("/update/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user) {

		User updatedUser = userService.updateUser(username, user);

		return ResponseEntity.ok(updatedUser);

		/*
		 * Postman PUT url: http://localhost:9001/users/update/abc
		 * 
		 * Postman Body:
		 * 
		 * { "username": "abc" , "password": "abcc" , "email": "abcc@yahoo.com"
		 * 
		 * }
		 * 
		 */

	}

	@PatchMapping("/update/{username}")
	public ResponseEntity<User> updateUserEmail(@PathVariable("username") String username, @RequestBody String email) {

		User updatedUser = userService.updateUserEmail(username, email);

		return ResponseEntity.ok(updatedUser);

		// Postman PATCH url: http://localhost:9001/users/update/abc
		// Postman Body: abc1@yahoo.com

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

		return "Hello World!";
	}

}
