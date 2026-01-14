package com.spring_user_service_simple_globalexception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUserException(String message) {

		super(message);

	}
}