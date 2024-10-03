package com.user_service_inmemory_bcrypt_password_encoder.service;

import java.util.List;

import com.user_service_inmemory_bcrypt_password_encoder.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
