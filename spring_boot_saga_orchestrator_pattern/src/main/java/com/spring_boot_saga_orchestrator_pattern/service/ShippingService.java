package com.spring_boot_saga_orchestrator_pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring_boot_saga_orchestrator_pattern.model.OrderRequest;
import com.spring_boot_saga_orchestrator_pattern.model.ShippingRequest;

@Service
public class ShippingService {

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<String> processShipping(OrderRequest orderRequest) {

		ShippingRequest shippingRequest = new ShippingRequest();
		shippingRequest.setOrderId(orderRequest.getOrderId());
		shippingRequest.setProduct(orderRequest.getProduct());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<ShippingRequest> shippingRequestEntity = new HttpEntity<>(shippingRequest, headers);

		ResponseEntity<String> shippingResponseEntity = restTemplate
				.postForEntity("http://localhost:9001/shipping/ship", shippingRequestEntity, String.class);

		return shippingResponseEntity;

	}

}
