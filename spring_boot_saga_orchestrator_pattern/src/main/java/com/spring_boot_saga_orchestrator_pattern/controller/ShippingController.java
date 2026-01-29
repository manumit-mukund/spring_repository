package com.spring_boot_saga_orchestrator_pattern.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_saga_orchestrator_pattern.model.ShippingRequest;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

	@PostMapping("/ship")
	public ResponseEntity<String> shipOrder(@RequestBody ShippingRequest shippingRequest) {

		// Assume shipping logic here
		if (shippingRequest.getProduct() != null && !shippingRequest.getProduct().isEmpty()) {

			return new ResponseEntity<>("Shipping successful", HttpStatus.OK);

		} else {

			return new ResponseEntity<>("Shipping failed", HttpStatus.BAD_REQUEST);

		}
	}
}
