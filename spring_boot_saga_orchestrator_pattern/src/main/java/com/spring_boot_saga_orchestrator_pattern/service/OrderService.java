package com.spring_boot_saga_orchestrator_pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_saga_orchestrator_pattern.model.OrderRequest;

@Service
public class OrderService {

	@Autowired
	private SagaOrchestrator sagaOrchestrator;

	public void createOrder(OrderRequest orderRequest) {

		sagaOrchestrator.startSaga(orderRequest);

	}
}
