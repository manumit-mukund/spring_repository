package com.user_service_calling_contact_thru_api_with_eureka.service;

import java.util.List;

import com.user_service_calling_contact_thru_api_with_eureka.model.User;

public interface UserService {

	public User getUser(Long id);

	public List<User> getAllUsers();

	public User addUser(User user);

}
