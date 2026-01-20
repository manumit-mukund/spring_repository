package com.spring_boot_circuit_breaker_with_retry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_circuit_breaker_with_retry.service.PaymentService;

@RestController
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {

		this.paymentService = paymentService;

	}

	@GetMapping("/pay")
	public String pay() {

		return paymentService.processPayment();
		
		//Test url: http://localhost:9001/pay

	}
}
