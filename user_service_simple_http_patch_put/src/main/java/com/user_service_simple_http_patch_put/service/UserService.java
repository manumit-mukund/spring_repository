package com.user_service_simple_http_patch_put.service;

import java.util.List;

import com.user_service_simple_http_patch_put.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);
	
	public User updateUserEmail(String username, String email);
	
	public User updateUser(String username, User user);

}
