package com.user_service_calling_contact_without_eureka_webclient_synchronous.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service_calling_contact_without_eureka_webclient_synchronous.model.Contact;
import com.user_service_calling_contact_without_eureka_webclient_synchronous.model.User;
import com.user_service_calling_contact_without_eureka_webclient_synchronous.service.ContactService;
import com.user_service_calling_contact_without_eureka_webclient_synchronous.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ContactService contactService;

	@GetMapping("/{userId}")
	@CircuitBreaker(name = "userService", fallbackMethod = "getUserFallback")
	public User getUser(@PathVariable("userId") Long userId) {

		User user = userService.getUser(userId);

		List<Contact> listContact = contactService.getContactsOfUser(userId);

		user.setContacts(listContact);

		return user;

		// Test url: http://localhost:9001/users/1311

	}

	public User getUserFallback(Long userId, Throwable t) {

		User user = userService.getUser(userId);

		// Log the error or handle it gracefully
		System.err.println("Fallback triggered for getUserFallback: " + t.getMessage() + ", Long userId = " + userId);

		return user;
	}

	@GetMapping("/getall")
	@CircuitBreaker(name = "userService", fallbackMethod = "getAllUsersFallback")
	public List<User> getAllUsers() {

		List<Contact> listContact = contactService.getAllContacts();

		for (User user : userService.getAllUsers()) {

			Long userId = user.getUserId();

			user.setContacts(listContact
					.stream()
					.filter(contact -> contact.getUserId().equals(userId))
					.collect(Collectors.toList()));
		}

		return userService.getAllUsers();

		// Test url: http://localhost:9001/users/getall
	}

	public List<User> getAllUsersFallback(Throwable t) {

		// Log the error or handle it gracefully
		System.err.println("Fallback triggered for getAllUsersFallback: " + t.getMessage());

		return userService.getAllUsers();
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {

		return userService.addUser(user);

	}

	/*
	 * Test url: http://localhost:9001/users/add
	 * 
	 * Postman data:
	 * 
	 * {
	 * 
	 * "userId": "1314" , "username": "pqr1" , "phone": "126"
	 * 
	 * }
	 * 
	 */

}
