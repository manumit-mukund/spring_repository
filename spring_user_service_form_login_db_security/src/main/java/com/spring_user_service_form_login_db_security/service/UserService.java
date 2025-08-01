package com.spring_user_service_form_login_db_security.service;

import java.util.List;

import com.spring_user_service_form_login_db_security.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
