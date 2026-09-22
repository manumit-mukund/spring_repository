package com.spring_boot_saga_orchestrator_pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring_boot_saga_orchestrator_pattern.model.OrderRequest;
import com.spring_boot_saga_orchestrator_pattern.model.PaymentRequest;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<String> processPayment(OrderRequest orderRequest) {

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(orderRequest.getOrderId());
		paymentRequest.setAmount(orderRequest.getAmount());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<PaymentRequest> paymentRequestEntity = new HttpEntity<>(paymentRequest, headers);

		ResponseEntity<String> paymentResponseEntity = restTemplate
				.postForEntity("http://localhost:9001/payment/process", paymentRequestEntity, String.class);

		return paymentResponseEntity;

	}

	public ResponseEntity<String> compensateOrder(OrderRequest orderRequest) {

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(orderRequest.getOrderId());
		paymentRequest.setAmount(-orderRequest.getAmount());

		System.out.println("compensateOrder: paymentRequest = " + paymentRequest);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<PaymentRequest> paymentRequestEntity = new HttpEntity<>(paymentRequest, headers);

		ResponseEntity<String> paymentResponseEntity = restTemplate
				.postForEntity("http://localhost:9001/payment/process", paymentRequestEntity, String.class);

		return paymentResponseEntity;

	}

}
