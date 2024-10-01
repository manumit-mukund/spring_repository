package com.user_service_calling_contact_without_eureka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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

		List<Contact> contacs = restTemplate.getForObject("http://localhost:9002/contact/user/" + userId, List.class);

		user.setContacts(contacs);

		return user;

	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {

		return userService.getAllUsers();
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {

		return userService.addUser(user);

	}

}
