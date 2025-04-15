package com.user_service_simple_log_using_slf4j_logger.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.user_service_simple_log_using_slf4j_logger.model.User;

@Service //If we put it on the UserService interface and not here, there will be an error
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private List<User> listUser;

	public UserServiceImpl() {

		super();

		logger.info("Performing an action on UserServiceImpl()...");

		listUser = new ArrayList<User>();
		listUser.add(new User("abc", "abc", "abc@yahoo.com"));
		listUser.add(new User("xyz", "xyz", "xyz@yahoo.com"));

		logger.debug("Action completed successfully UserServiceImpl().");

	}

	@Override
	public User getUser(String username) {

		logger.info("Performing an action on getUser(String username)...");

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

}
