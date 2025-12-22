package com.spring_boot_circuit_breaker_with_hystrix.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring_boot_circuit_breaker_with_hystrix.exception.ServiceFailureException;

@Service
public class MyService {

	@HystrixCommand(fallbackMethod = "fallbackHello")
	public String sayHello() {

		// Simulate a service call
		if (new Random().nextBoolean()) {

			throw new ServiceFailureException("Service call failed");

		}

		return "Hello from service";
	}

	public String fallbackHello() {

		return "Fallback: Hello from service";

	}
}
