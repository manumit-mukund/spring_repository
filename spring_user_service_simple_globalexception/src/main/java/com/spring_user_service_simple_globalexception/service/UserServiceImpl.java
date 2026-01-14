package com.spring_user_service_simple_globalexception.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_user_service_simple_globalexception.controller.InvalidUserException;
import com.spring_user_service_simple_globalexception.controller.ResourceNotFoundException;
import com.spring_user_service_simple_globalexception.model.User;

@Service
public class UserServiceImpl implements UserService {

	private List<User> listUser;

	public UserServiceImpl() {

		super();

		listUser = new ArrayList<User>();
		listUser.add(new User("abc", "abc", "abc@yahoo.com"));
		listUser.add(new User("xyz", "xyz", "xyz@yahoo.com"));

	}

	@Override
	public User getUser(String username) {

		return listUser
				.stream()
				.filter(user -> user.getUsername().equals(username)).findAny()
				.orElseThrow(() -> new ResourceNotFoundException("user not found with username : " + username));

	}

	@Override
	public List<User> getAllUsers() {

		return listUser;
	}

	@Override
	public User addUser(User user) {

		if (user.getUsername() != null && user.getUsername().trim().length() != 0) {

			listUser.add(user);

			return user;

		} else {

			throw new InvalidUserException("Invalid username");
		}

	}

}
