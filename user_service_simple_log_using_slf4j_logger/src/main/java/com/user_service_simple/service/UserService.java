package com.user_service_simple.service;

import java.util.List;

import com.user_service_simple.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
