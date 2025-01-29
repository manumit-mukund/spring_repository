package com.spring_boot_transaction_management_propogation_isolation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_transaction_management_propogation_isolation.dto.OrderDto;
import com.spring_boot_transaction_management_propogation_isolation.entity.Order;
import com.spring_boot_transaction_management_propogation_isolation.entity.User;
import com.spring_boot_transaction_management_propogation_isolation.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {

		User user = new User(orderDto.getUsername());

		Order order = new Order(orderDto.getOrderId());

		orderService.createOrder(order, user);

		return ResponseEntity.ok("Order created successfully");

	}
}
