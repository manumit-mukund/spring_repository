package com.user_service_calling_contact_without_eureka_circuitbreaker_retry.service;

import java.util.List;

import com.user_service_calling_contact_without_eureka_circuitbreaker_retry.model.Contact;
import com.user_service_calling_contact_without_eureka_circuitbreaker_retry.model.User;

public interface UserService {

	public User getUser(Long id);

	public List<User> getAllUsers();

	public User addUser(User user);

	public List<Contact> getContactsOfUser(Long userId);

	// public List<Contact> getAllContacts();

}
