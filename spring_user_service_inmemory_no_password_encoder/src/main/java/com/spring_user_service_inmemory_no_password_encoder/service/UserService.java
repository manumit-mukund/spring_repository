package com.spring_user_service_inmemory_no_password_encoder.service;

import java.util.List;

import com.spring_user_service_inmemory_no_password_encoder.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
