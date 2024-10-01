package com.contact_service_without_eureka.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.contact_service_without_eureka.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private List<Contact> listContact;

	public ContactServiceImpl(List<Contact> listContact) {
		super();		
	}

	public ContactServiceImpl() {
		super();		
		listContact = List.of(
				new Contact(1L, "c1@gail.com", "c1", 1311L),
				new Contact(2L, "c2@gail.com", "c2", 1311L), 
				new Contact(3L, "c3@gail.com", "c3", 1312L),
				new Contact(4L, "c4@gail.com", "c4", 1313L));
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Contact> getContactsOfUser(Long userId) {
		// TODO Auto-generated method stub
		return listContact.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
