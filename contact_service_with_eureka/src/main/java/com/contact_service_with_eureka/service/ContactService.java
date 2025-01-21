package com.contact_service_with_eureka.service;

import java.util.List;

import com.contact_service_with_eureka.model.Contact;

public interface ContactService {

	public List<Contact> getContactsOfUser(Long userId);

	public List<Contact> getAllContacts();

}
