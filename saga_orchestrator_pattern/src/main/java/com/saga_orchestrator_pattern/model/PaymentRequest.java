package com.saga_orchestrator_pattern.model;

public class PaymentRequest {

	private Long orderId;
	private Double amount;

	public PaymentRequest() {
		super();

	}

	public PaymentRequest(Long orderId, Double amount) {
		super();
		this.orderId = orderId;
		this.amount = amount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentRequest [orderId=" + orderId + ", amount=" + amount + "]";
	}

}
