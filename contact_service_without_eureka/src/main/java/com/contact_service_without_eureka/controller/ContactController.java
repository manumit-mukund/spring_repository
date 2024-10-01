package com.contact_service_without_eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.contact_service_without_eureka.model.Contact;
import com.contact_service_without_eureka.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/user/{userId}")
	public List<Contact> getContactsOfUser(@PathVariable("userId") Long userId) {
		return contactService.getContactsOfUser(userId);
	}

}
