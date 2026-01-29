package com.spring_boot_saga_orchestrator_pattern.model;

public class ShippingRequest {

	private Long orderId;
	private String product;

	public ShippingRequest() {

		super();

	}

	public ShippingRequest(Long orderId, String product) {
		super();
		this.orderId = orderId;
		this.product = product;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ShippingRequest [orderId=" + orderId + ", product=" + product + "]";
	}
	
	

}
