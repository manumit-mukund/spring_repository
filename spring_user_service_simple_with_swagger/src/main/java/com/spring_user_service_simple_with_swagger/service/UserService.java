package com.spring_user_service_simple_with_swagger.service;

import java.util.List;

import com.spring_user_service_simple_with_swagger.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
