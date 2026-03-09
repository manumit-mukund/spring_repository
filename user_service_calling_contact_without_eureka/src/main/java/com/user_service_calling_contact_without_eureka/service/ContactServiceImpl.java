package com.user_service_calling_contact_without_eureka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user_service_calling_contact_without_eureka.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Contact> getContactsOfUser(Long userId) {

		List<Contact> listContact = restTemplate.getForObject("http://localhost:9002/contact/user/" + userId,
				List.class);

		return listContact;

	}

	@Override
	public List<Contact> getAllContacts() {
		
		List<Contact> listContactResult = restTemplate.getForObject("http://localhost:9002/contact/getall", List.class);

		ObjectMapper mapper = new ObjectMapper();

		List<Contact> listContact = mapper.convertValue(listContactResult, new TypeReference<List<Contact>>() {
		});

		return listContact;

	}

}
