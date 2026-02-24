package com.user_service_calling_contact_without_eureka_webclient_synchronous.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.user_service_calling_contact_without_eureka_webclient_synchronous.model.Contact;

@Service
public class ContactService {

	private final WebClient webClient;

	public ContactService(WebClient.Builder webClientBuilder) {

//		WebClient webClient = WebClient.create("http://localhost:9002");

		this.webClient = webClientBuilder.baseUrl("http://localhost:9002").build();

	}

	// Method to retrieve a list of contacts synchronously
	public List<Contact> getContactsOfUser(Long userId) {

		List<Contact> listContact = webClient
				.get()
				.uri("/contact/user/" + userId)
				.retrieve()
				.bodyToFlux(Contact.class)
				.collectList()
				.block();

		return listContact;
	}

	public List<Contact> getAllContacts() {

		List<Contact> listContact = webClient
				.get()
				.uri("/contact/getall")
				.retrieve()
				.bodyToFlux(Contact.class)
				.collectList()
				.block();

		return listContact;

	}

}
