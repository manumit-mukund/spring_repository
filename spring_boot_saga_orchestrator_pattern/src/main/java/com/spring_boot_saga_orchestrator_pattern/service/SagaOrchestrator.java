package com.spring_boot_saga_orchestrator_pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_boot_saga_orchestrator_pattern.model.OrderRequest;

@Service
public class SagaOrchestrator {

	// private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ShippingService shippingService;

	public void startSaga(OrderRequest orderRequest) {

		try {

			// Subtask-1 of saga: Process payment
			ResponseEntity<String> paymentResponseEntity = paymentService.processPayment(orderRequest);

//			if (paymentResponseEntity.getStatusCode().is2xxSuccessful()) {
//
//				System.out.println("startSaga: paymentResponseEntity = " + paymentResponseEntity);
//
//			} else {
//
//				compensateOrder(orderRequest);
//			}

			if (paymentResponseEntity.getStatusCode() == HttpStatus.BAD_REQUEST) {

				System.out.println("Calling compensateOrder(orderRequest)...");
				compensateOrder(orderRequest);

			}

			// Subtask-2 of saga: Ship the order
			ResponseEntity<String> shippingResponseEntity = shippingService.processShipping(orderRequest);

			if (shippingResponseEntity.getStatusCode().is2xxSuccessful()) {

				System.out.println("startSaga: shippingResponseEntity = " + shippingResponseEntity);

			} else {

				compensateOrder(orderRequest);
			}

		} catch (Exception e) {

			System.out.println("Exception: " + e.getMessage());
			// compensateOrder(orderRequest);

		}

	}

	private void compensateOrder(OrderRequest orderRequest) {

		ResponseEntity<String> paymentResponseEntity = paymentService.compensateOrder(orderRequest);

		if (paymentResponseEntity.getStatusCode().is2xxSuccessful()) {

			System.out.println("compensateOrder: paymentResponseEntity = " + paymentResponseEntity);

		} else {

			System.out.println("compensateOrder: paymentResponseEntity = " + paymentResponseEntity);

			// throw new RuntimeException("Payment failed");
		}

	}
}
