package com.user_service_spring_secure.service;

import java.util.List;

import com.user_service_spring_secure.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
