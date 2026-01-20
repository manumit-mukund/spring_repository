package com.user_service_calling_contact_without_eureka_circuitbreaker_retry.exception;

public class RemoteServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RemoteServiceException(String message) {

		super(message);

	}
}
