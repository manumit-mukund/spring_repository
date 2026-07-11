package com.user_service_calling_contact_thru_api_with_eureka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user_service_calling_contact_thru_api_with_eureka.model.User;

@Service
public class UserServiceImpl implements UserService {

	private List<User> listUser;

	public UserServiceImpl() {
		super();
		listUser = new ArrayList<User>();
		listUser.add(new User(101L, "ABC", "98116"));
		listUser.add(new User(102L, "XYZ", "98117"));
		listUser.add(new User(103L, "PQR", "98118"));

	}

	@Override
	public User getUser(Long id) {

		return listUser
				.stream()
				.filter(user -> user.getUserId().equals(id))
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
