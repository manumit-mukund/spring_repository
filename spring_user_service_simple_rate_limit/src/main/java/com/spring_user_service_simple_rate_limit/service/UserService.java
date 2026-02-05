package com.spring_user_service_simple_rate_limit.service;

import java.util.List;

import com.spring_user_service_simple_rate_limit.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
