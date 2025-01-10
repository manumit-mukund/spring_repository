package com.user_service_simple_log_using_slf4j_logger.service;

import java.util.List;

import com.user_service_simple_log_using_slf4j_logger.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}