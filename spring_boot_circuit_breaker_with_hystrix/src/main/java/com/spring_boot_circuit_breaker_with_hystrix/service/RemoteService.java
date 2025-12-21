package com.spring_boot_circuit_breaker_with_hystrix.service;

public interface RemoteService {

	String callService() throws InterruptedException;

}