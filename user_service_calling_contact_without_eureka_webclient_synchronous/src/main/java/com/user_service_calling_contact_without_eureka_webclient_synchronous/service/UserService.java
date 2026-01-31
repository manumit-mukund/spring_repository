package com.user_service_calling_contact_without_eureka_webclient_synchronous.service;

import java.util.List;

import com.user_service_calling_contact_without_eureka_webclient_synchronous.model.User;

public interface UserService {

	public User getUser(Long id);

	public List<User> getAllUsers();

	public User addUser(User user);

}
