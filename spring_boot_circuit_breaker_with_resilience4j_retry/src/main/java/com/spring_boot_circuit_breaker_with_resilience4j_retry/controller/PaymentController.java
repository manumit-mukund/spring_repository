package com.spring_boot_circuit_breaker_with_resilience4j_retry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_resilience4j_retry.service.PaymentService;

@RestController
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {

		this.paymentService = paymentService;

	}

	@GetMapping("/pay")
	public String pay() {

		return paymentService.processPayment();

	}
}
