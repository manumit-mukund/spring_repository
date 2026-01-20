package com.user_service_calling_contact_without_eureka_circuitbreaker_retry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user_service_calling_contact_without_eureka_circuitbreaker_retry.exception.ResourceNotFoundException;
import com.user_service_calling_contact_without_eureka_circuitbreaker_retry.model.Contact;
import com.user_service_calling_contact_without_eureka_circuitbreaker_retry.model.User;

@Service
public class UserServiceImpl implements UserService {

	private List<User> listUser;
	private List<Contact> listContact;

	private int attempt = 0;

	@Autowired
	private RestTemplate restTemplate;

	public UserServiceImpl() {

		super();

		listUser = new ArrayList<>();
		listUser.add(new User(1311L, "ABC", "123"));
		listUser.add(new User(1312L, "XYZ", "124"));
		listUser.add(new User(1313L, "PQR", "125"));

		listContact = new ArrayList<>();

	}

	@Override
	public User getUser(Long id) {

		return listUser.stream().filter(user -> user.getUserId().equals(id)).findAny()
				.orElseThrow(() -> new ResourceNotFoundException("user not found with that userid : " + id));

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
	@Retryable(retryFor = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay = 10000))
	public List<Contact> getContactsOfUser(Long userId) {

		System.out.println("Calling external API. Attempt: " + ++attempt);

		List<Contact> listCcontacs = restTemplate.getForObject("http://localhost:9002/contact/user/" + userId,
				List.class);

		return listCcontacs;

	}

	@Recover
	public List<Contact> retryFallback(Throwable t) {

		System.err.println("All retries failed. Executing retry fallback logic. Exception: " + t.getMessage());

		attempt = 0;

		return listContact;
	}

}
