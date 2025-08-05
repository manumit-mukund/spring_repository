package com.spring_user_service_simple_http_patch_put.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_user_service_simple_http_patch_put.exception.ResourceNotFoundException;
import com.spring_user_service_simple_http_patch_put.model.User;

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
				.filter(user -> user.getUsername().equals(username))
				.findAny()
				.orElseThrow(() -> new ResourceNotFoundException("user not found with username : " + username));

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

	@Override
	public User updateUser(String username, User user) {

		User user1 = getUser(username);

		if (user1 != null) {

			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());

		}

		return user1;

	}

	@Override
	public User deleteUser(String username) {

		User user = getUser(username);

		if (user != null) {

			listUser.remove(user);

		}

		return user;

	}
}
