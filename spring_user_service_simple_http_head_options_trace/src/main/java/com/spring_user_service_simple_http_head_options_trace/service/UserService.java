package com.spring_user_service_simple_http_head_options_trace.service;

import java.util.List;

import com.spring_user_service_simple_http_head_options_trace.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);
	
	public User updateUserEmail(String username, String email);
	
	public User updateUser(String username, User user);
	
	public User deleteUser(String username);

}
