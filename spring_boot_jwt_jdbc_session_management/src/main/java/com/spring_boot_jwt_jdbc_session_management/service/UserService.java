package com.spring_boot_jwt_jdbc_session_management.service;

import org.springframework.stereotype.Service;

import com.spring_boot_jwt_jdbc_session_management.entity.User;
import com.spring_boot_jwt_jdbc_session_management.exception.UserNotFoundException;

@Service
public interface UserService {

	public void saveUser(User user);

	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
