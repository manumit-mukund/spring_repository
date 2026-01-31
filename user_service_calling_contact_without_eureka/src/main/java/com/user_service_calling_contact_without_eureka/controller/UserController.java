package com.user_service_calling_contact_without_eureka.controller;

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
import com.user_service_calling_contact_without_eureka.model.Contact;
import com.user_service_calling_contact_without_eureka.model.User;
import com.user_service_calling_contact_without_eureka.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {

		User user = userService.getUser(userId);

		long startTime = System.currentTimeMillis();

		System.out.println("Calling API 1...");
		List<Contact> listContact1 = restTemplate.getForObject("http://localhost:9002/contact/user/" + userId,
				List.class);
		System.out.println("API 1 Response: " + listContact1);

		System.out.println("\nCalling API 2...");
		List<Contact> listContact2 = restTemplate.getForObject("http://localhost:9002/contact/user/" + userId,
				List.class);
		System.out.println("API 2 Response: " + listContact2);

		System.out.println("\nCalling API 3...");
		List<Contact> listContact3 = restTemplate.getForObject("http://localhost:9002/contact/user/" + userId,
				List.class);
		System.out.println("API 3 Response: " + listContact3);

		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + " ms");

		user.setContacts(listContact1);

		return user;

		// Test url: http://localhost:9001/users/1311

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
