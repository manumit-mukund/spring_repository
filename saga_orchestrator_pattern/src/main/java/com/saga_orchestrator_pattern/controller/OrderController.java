package com.saga_orchestrator_pattern.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saga_orchestrator_pattern.model.OrderRequest;
import com.saga_orchestrator_pattern.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {

		this.orderService = orderService;

	}

	@PostMapping("/create")
	public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {

		try {

			orderService.createOrder(orderRequest);

			return new ResponseEntity<>("Order created successfully", HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>("Order creation failed", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
