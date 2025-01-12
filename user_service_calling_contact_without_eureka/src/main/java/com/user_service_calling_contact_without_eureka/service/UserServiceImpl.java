package com.user_service_calling_contact_without_eureka.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.user_service_calling_contact_without_eureka.model.User;

@Service
public class UserServiceImpl implements UserService {

	private List<User> listUser;

	public UserServiceImpl() {
		
		super();
		
		listUser = new ArrayList<User>();
		listUser.add(new User(1311L, "ABC", "123"));
		listUser.add(new User(1312L, "XYZ", "124"));
		listUser.add(new User(1313L, "PQR", "125"));
		

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
