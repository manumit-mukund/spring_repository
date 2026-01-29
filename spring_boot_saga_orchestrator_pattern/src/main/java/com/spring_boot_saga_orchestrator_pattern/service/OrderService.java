package com.spring_boot_saga_orchestrator_pattern.service;

import org.springframework.stereotype.Service;

import com.spring_boot_saga_orchestrator_pattern.model.OrderRequest;

@Service
public class OrderService {

	private final SagaOrchestrator sagaOrchestrator;

	public OrderService(SagaOrchestrator sagaOrchestrator) {

		this.sagaOrchestrator = sagaOrchestrator;

	}

	public void createOrder(OrderRequest orderRequest) {

		sagaOrchestrator.startSaga(orderRequest);

	}
}
