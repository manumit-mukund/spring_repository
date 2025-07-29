package com.spring_user_service_simple_globalexception.service;

import java.util.List;

import com.spring_user_service_simple_globalexception.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
