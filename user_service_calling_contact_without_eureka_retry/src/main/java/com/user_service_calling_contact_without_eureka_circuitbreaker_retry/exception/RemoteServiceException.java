package com.user_service_calling_contact_without_eureka_circuitbreaker_retry.exception;

public class RemoteServiceException extends RuntimeException {

	public RemoteServiceException(String message) {

		super(message);

	}
}
