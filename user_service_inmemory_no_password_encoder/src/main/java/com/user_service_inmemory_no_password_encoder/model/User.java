package com.user_service_inmemory_no_password_encoder.model;

public class User {

	private String username;
	private String password;
	private String emai;

	public User() {

		super();

	}

	public User(String username, String password, String emai) {
		super();
		this.username = username;
		this.password = password;
		this.emai = emai;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmai() {
		return emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}

}
