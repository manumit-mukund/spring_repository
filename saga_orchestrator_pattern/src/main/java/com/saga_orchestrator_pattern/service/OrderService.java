package com.saga_orchestrator_pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga_orchestrator_pattern.model.OrderRequest;

@Service
public class OrderService {

	@Autowired
	private final SagaOrchestrator sagaOrchestrator;

	public OrderService(SagaOrchestrator sagaOrchestrator) {

		this.sagaOrchestrator = sagaOrchestrator;

	}

	public void createOrder(OrderRequest orderRequest) {

		sagaOrchestrator.startSaga(orderRequest);

	}
}
