package com.spring_user_service_simple_log_using_lombok.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_user_service_simple_log_using_lombok.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private List<User> listUser;

	public UserServiceImpl() {

		super();

		log.info("UserServiceImpl(): info: Performing an action on UserServiceImpl()...");

		listUser = new ArrayList<User>();
		listUser.add(new User("abc", "abc", "abc@yahoo.com"));
		listUser.add(new User("xyz", "xyz", "xyz@yahoo.com"));

		log.debug("UserServiceImpl(): debug: Action completed successfully UserServiceImpl().");
		log.warn("UserServiceImpl(): warn: Action completed successfully UserServiceImpl().");
		log.error("UserServiceImpl(): error: Action completed successfully UserServiceImpl().");

	}

	@Override
	public User getUser(String username) {

		log.info("getUser(String username): info: Performing an action on ...");

		return listUser
				.stream()
				.filter(user -> user.getUsername().equals(username))
				.findAny()
				.orElse(null);

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
