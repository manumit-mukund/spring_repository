package com.saga_orchestrator_pattern.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saga_orchestrator_pattern.model.OrderRequest;
import com.saga_orchestrator_pattern.model.PaymentRequest;
import com.saga_orchestrator_pattern.model.ShippingRequest;

@Service
public class SagaOrchestrator {

	private final RestTemplate restTemplate = new RestTemplate();

	public void startSaga(OrderRequest orderRequest) {

		try {
			// Step 1: Process payment
			PaymentRequest paymentRequest = new PaymentRequest();
			paymentRequest.setOrderId(orderRequest.getOrderId());
			paymentRequest.setAmount(orderRequest.getAmount());

			System.out.println("paymentRequest = " + paymentRequest);

			ResponseEntity<String> paymentResponse = restTemplate.postForEntity("http://localhost:9001/payment/process",
					paymentRequest, String.class);

			if (!paymentResponse.getStatusCode().is2xxSuccessful()) {

				throw new RuntimeException("Payment failed");

			}

			// Step 2: Ship the order
			ShippingRequest shippingRequest = new ShippingRequest();
			shippingRequest.setOrderId(orderRequest.getOrderId());
			shippingRequest.setProduct(orderRequest.getProduct());

			System.out.println("shippingRequest = " + shippingRequest);

			ResponseEntity<String> shippingResponse = restTemplate.postForEntity("http://localhost:9001/shipping/ship",
					shippingRequest, String.class);

			if (!shippingResponse.getStatusCode().is2xxSuccessful()) {

				throw new RuntimeException("Shipping failed");

			}
		} catch (Exception e) {

			// Compensation logic
			compensateOrder(orderRequest);

			throw new RuntimeException("Saga failed, compensating...");
		}
	}

	private void compensateOrder(OrderRequest orderRequest) {

		// Compensation logic (e.g., refund payment)
		System.out.println("Compensating for order: " + orderRequest.getOrderId());

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(orderRequest.getOrderId());
		paymentRequest.setAmount(-orderRequest.getAmount());

		System.out.println("paymentRequest1 = " + paymentRequest);

		restTemplate.postForEntity("http://localhost:9001/payment/process", paymentRequest, String.class);

	}
}
