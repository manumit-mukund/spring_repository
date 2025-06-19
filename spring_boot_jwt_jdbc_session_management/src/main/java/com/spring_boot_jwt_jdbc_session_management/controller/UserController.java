package com.spring_boot_jwt_jdbc_session_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_jwt_jdbc_session_management.entity.User;
import com.spring_boot_jwt_jdbc_session_management.exception.UserNotFoundException;
import com.spring_boot_jwt_jdbc_session_management.service.JwtGeneratorInterface;
import com.spring_boot_jwt_jdbc_session_management.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	private UserService userService;
	private JwtGeneratorInterface jwtGenerator;

	@Autowired
	public UserController(UserService userService, JwtGeneratorInterface jwtGenerator) {

		this.userService = userService;
		this.jwtGenerator = jwtGenerator;

	}

	@PostMapping("/register")
	public ResponseEntity<?> postUser(@RequestBody User user) {

		try {

			userService.saveUser(user);

			return new ResponseEntity<>(user, HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

		}
		
		/*
		 * Test url in Postman: http://localhost:9001/api/v1/user/register
		 * 
		 * JSON data in Body tab / raw:
		 * 
		 * {
		 * 
		 * "userName":"Alice", 
		 * "password":"pass123"
		 * 
		 * }
		 * 
		 */
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {

		try {

			if (user.getUserName() == null || user.getPassword() == null) {

				throw new UserNotFoundException("UserName or Password is Empty");

			}
			User userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());

			if (userData == null) {

				throw new UserNotFoundException("UserName or Password is Invalid");

			}

			return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);

		} catch (UserNotFoundException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

		}
		
		/*
		 * Test url in Postman: http://localhost:9001/api/v1/user/login
		 * 
		 * JSON data in Body tab / raw:
		 * 
		 * {
		 * 
		 * "userName":"Alice", 
		 * "password":"pass123"
		 * 
		 * }
		 * 
		 */
	}
}