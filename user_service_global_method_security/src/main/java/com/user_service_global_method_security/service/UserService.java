package com.user_service_global_method_security.service;

import java.util.List;

import com.user_service_global_method_security.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
