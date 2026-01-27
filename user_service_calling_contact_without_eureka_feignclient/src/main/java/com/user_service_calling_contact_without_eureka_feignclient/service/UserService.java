package com.user_service_calling_contact_without_eureka_feignclient.service;

import java.util.List;

import com.user_service_calling_contact_without_eureka_feignclient.model.User;

public interface UserService {

	public User getUser(Long id);

	public List<User> getAllUsers();

	public User addUser(User user);

}
