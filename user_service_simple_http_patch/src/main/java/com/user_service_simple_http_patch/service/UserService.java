package com.user_service_simple_http_patch.service;

import java.util.List;

import com.user_service_simple_http_patch.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);
	
	public User updateUserEmail(String username, String email);

}
