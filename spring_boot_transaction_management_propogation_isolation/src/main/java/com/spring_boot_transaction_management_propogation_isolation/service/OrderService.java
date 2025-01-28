package com.spring_boot_transaction_management_propogation_isolation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring_boot_transaction_management_propogation_isolation.entity.Order;
import com.spring_boot_transaction_management_propogation_isolation.entity.User;
import com.spring_boot_transaction_management_propogation_isolation.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserService userService;

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public void createOrder(Order order, User user) {

		userService.createUser(user); // Calls createUser in a new transaction
		orderRepository.save(order); // Saves order with SERIALIZABLE isolation

	}
}