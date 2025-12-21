package com.spring_boot_circuit_breaker_with_hystrix.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring_boot_circuit_breaker_with_hystrix.exception.ServiceFailureException;

@Service
public class RemoteServiceSimulator implements RemoteService {

	@HystrixCommand(fallbackMethod = "reliable")
	public String callService() throws InterruptedException {

		if (new Random().nextBoolean()) {

			throw new ServiceFailureException("Service Failure!");

		}

		return "Successfully called service!";
	}

	public String reliable() {

		return "Default Response";

	}
}