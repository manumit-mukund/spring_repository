package com.user_service_calling_contact_without_eureka.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Long userId;
	private String username;
	private String phone;

	private List<Contact> contacts = new ArrayList<Contact>();

	public User() {
		super();
	}

	public User(Long userId, String name, String phone) {
		
		super();
		this.userId = userId;
		this.username = name;
		this.phone = phone;
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
