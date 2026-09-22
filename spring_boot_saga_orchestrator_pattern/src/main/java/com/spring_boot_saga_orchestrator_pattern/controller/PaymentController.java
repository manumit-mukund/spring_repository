package com.spring_boot_saga_orchestrator_pattern.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_saga_orchestrator_pattern.model.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@PostMapping("/process")
	public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {

		//PaymentResponse paymentResponse = new PaymentResponse(paymentRequest.getOrderId(), paymentRequest.getAmount());
		
		if (paymentRequest.getAmount() > 0) {

			return new ResponseEntity<>(HttpStatus.OK);

		} else {
			
			System.out.println("HttpStatus.BAD_REQUEST");

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
}
