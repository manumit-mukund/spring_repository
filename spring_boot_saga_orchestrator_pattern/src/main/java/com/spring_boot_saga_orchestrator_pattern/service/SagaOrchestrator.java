package com.spring_boot_saga_orchestrator_pattern.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring_boot_saga_orchestrator_pattern.model.OrderRequest;
import com.spring_boot_saga_orchestrator_pattern.model.PaymentRequest;
import com.spring_boot_saga_orchestrator_pattern.model.ShippingRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SagaOrchestrator {

	private final RestTemplate restTemplate = new RestTemplate();

	public void startSaga(OrderRequest orderRequest) {

		try {
			// Step 1: Process payment
			PaymentRequest paymentRequest = new PaymentRequest();
			paymentRequest.setOrderId(orderRequest.getOrderId());
			paymentRequest.setAmount(orderRequest.getAmount());

			log.debug("paymentRequest = " + paymentRequest);

			ResponseEntity<String> paymentResponse = restTemplate.postForEntity("http://localhost:9001/payment/process",
					paymentRequest, String.class);

			System.out.println("paymentResponse = " + paymentResponse);

			if (!paymentResponse.getStatusCode().is2xxSuccessful()) {

				System.out.println("paymentResponse = " + paymentResponse);

				throw new RuntimeException("Payment failed");

			}

			// Step 2: Ship the order
			ShippingRequest shippingRequest = new ShippingRequest();
			shippingRequest.setOrderId(orderRequest.getOrderId());
			shippingRequest.setProduct(orderRequest.getProduct());

			log.debug("shippingRequest = " + shippingRequest);

			ResponseEntity<String> shippingResponse = restTemplate.postForEntity("http://localhost:9001/shipping/ship",
					shippingRequest, String.class);

			System.out.println("shippingResponse = " + shippingResponse);

			if (!shippingResponse.getStatusCode().is2xxSuccessful()) {

				System.out.println("shippingResponse = " + shippingResponse);

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
		log.error("Compensating for order: " + orderRequest.getOrderId());

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(orderRequest.getOrderId());
		paymentRequest.setAmount(-orderRequest.getAmount());

		log.info("paymentRequest1 = " + paymentRequest);

		restTemplate.postForEntity("http://localhost:9001/payment/process", paymentRequest, String.class);

	}
}
