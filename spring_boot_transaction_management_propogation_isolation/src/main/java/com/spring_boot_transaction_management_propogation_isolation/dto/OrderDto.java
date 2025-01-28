package com.spring_boot_transaction_management_propogation_isolation.dto;

public class OrderDto {

	private String username;
	private String orderId;

	public OrderDto() {
	}

	public OrderDto(String username, String orderId) {
		this.username = username;
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
