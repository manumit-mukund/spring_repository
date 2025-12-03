package com.user_service_calling_contact_without_eureka_with_circuitbreaker.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user_service_calling_contact_without_eureka_with_circuitbreaker.model.Contact;
import com.user_service_calling_contact_without_eureka_with_circuitbreaker.model.User;
import com.user_service_calling_contact_without_eureka_with_circuitbreaker.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	@CircuitBreaker(name = "myService", fallbackMethod = "getUserFallback")
	public User getUser(@PathVariable("userId") Long userId) {

		User user = userService.getUser(userId);

		List<Contact> contacs = restTemplate.getForObject("http://localhost:9002/contact/user/" + userId, List.class);

		user.setContacts(contacs);

		return user;

		// Test url: http://localhost:9001/users/1311

	}

	public User getUserFallback(Long userId, Throwable t) {

		User user = userService.getUser(userId);

		// Log the error or handle it gracefully
		System.err.println("Fallback triggered for getUserFallback: " + t.getMessage() + "Long userId = " + userId);

		return user;
	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		/*
		 * This is also working
		 * 
		 * for(User user: userService.getAllUsers()) {
		 * 
		 * List<Contact> contacs =
		 * restTemplate.getForObject("http://localhost:9002/contact/user/" +
		 * user.getUserId(), List.class);
		 * 
		 * user.setContacts(contacs); }
		 */

		List<Contact> listContactResult = restTemplate.getForObject("http://localhost:9002/contact/getall", List.class);

		ObjectMapper mapper = new ObjectMapper();

		List<Contact> listContact = mapper.convertValue(listContactResult, new TypeReference<List<Contact>>() {
		});

		for (User user : userService.getAllUsers()) {

			Long userId = user.getUserId();

			user.setContacts(listContact.stream().filter(contact -> contact.getUserId().equals(userId))
					.collect(Collectors.toList()));
		}

		return userService.getAllUsers();

		// Test url: http://localhost:9001/users/getall
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
