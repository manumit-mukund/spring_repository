package com.spring_boot_transaction_management_propogation_isolation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring_boot_transaction_management_propogation_isolation.entity.User;
import com.spring_boot_transaction_management_propogation_isolation.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public void createUser(User user) {

		userRepository.save(user); // Saves user with REPEATABLE_READ isolation

	}
}
