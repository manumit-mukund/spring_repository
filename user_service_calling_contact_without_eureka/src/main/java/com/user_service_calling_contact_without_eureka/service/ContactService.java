package com.user_service_calling_contact_without_eureka.service;

import java.util.List;

import com.user_service_calling_contact_without_eureka.model.Contact;

public interface ContactService {

	public List<Contact> getContactsOfUser(Long userId);

	public List<Contact> getAllContacts();

}
