package com.spring_boot_jwt_session_management.controller;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 6239921560724451905L;

	private String username;
	private String password;

	public JwtRequest() {

	}

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}