package com.user_service_simple_http_patch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user_service_simple_http_patch.model.User;

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

		return listUser.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);

	}

	@Override
	public List<User> getAllUsers() {

		return listUser;
	}

	@Override
	public User addUser(User user) {

		listUser.add(user);
		return user;

	}

	@Override
	public User updateUserEmail(String username, String email) {

		User user = getUser(username);

		if (user != null) {
			
			user.setEmail(email);

		}

		return user;

	}
}
