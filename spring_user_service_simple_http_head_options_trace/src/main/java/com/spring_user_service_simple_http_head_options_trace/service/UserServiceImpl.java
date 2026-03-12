package com.spring_user_service_simple_http_head_options_trace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_user_service_simple_http_head_options_trace.exception.ResourceNotFoundException;
import com.spring_user_service_simple_http_head_options_trace.model.User;

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

		return listUser.stream().filter(user -> user.getUsername().equals(username)).findAny()
				.orElseThrow(() -> new ResourceNotFoundException("user not found with username : " + username));

	}

	@Override
	public List<User> getAllUsers() {

		return listUser;
	}

}
