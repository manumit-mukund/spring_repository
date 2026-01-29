package com.spring_boot_saga_orchestrator_pattern.model;

public class OrderRequest {

	private Long orderId;
	private Double amount;
	private String product;

	public OrderRequest() {
		super();

	}

	public OrderRequest(Long orderId, Double amount, String product) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.product = product;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderId=" + orderId + ", amount=" + amount + ", product=" + product + "]";
	}

}
