package com.user_service_calling_contact_without_eureka_webclient.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.user_service_calling_contact_without_eureka_webclient.model.Contact;
import com.user_service_calling_contact_without_eureka_webclient.model.User;
import com.user_service_calling_contact_without_eureka_webclient.service.UserService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {

		User user = userService.getUser(userId);

		WebClient webClient = WebClient.create("http://localhost:9002");

		Mono<List<Contact>> monoListContact = webClient
				.get()
				.uri("/contact/user/" + userId)
				.retrieve()
				.bodyToFlux(Contact.class)
				.collectList();

		List<Contact> listContact = monoListContact.block();

		user.setContacts(listContact);

		return user;

		// Test url: http://localhost:9001/users/1311

	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		WebClient webClient = WebClient.create("http://localhost:9002");

		Mono<List<Contact>> monoListContact = webClient
				.get()
				.uri("/contact/getall")
				.retrieve()
				.bodyToFlux(Contact.class)
				.collectList();

		List<Contact> listContact = monoListContact.block();

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
