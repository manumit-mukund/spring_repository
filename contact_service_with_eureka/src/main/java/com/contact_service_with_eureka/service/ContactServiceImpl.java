package com.contact_service_with_eureka.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.contact_service_with_eureka.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private List<Contact> listContact;

	public ContactServiceImpl(List<Contact> listContact) {
		super();
	}

	public ContactServiceImpl() {
		super();
		listContact = List.of(
				new Contact(1L, "c1@gmail.com", "c1", 1311L), 
				new Contact(2L, "c2@gmail.com", "c2", 1311L),
				new Contact(3L, "c3@gmail.com", "c3", 1312L), 
				new Contact(4L, "c4@gmail.com", "c4", 1313L));

	}

	@Override
	public List<Contact> getContactsOfUser(Long userId) {

		return listContact.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
