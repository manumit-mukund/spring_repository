package com.spring_boot_circuit_breaker_with_hystrix.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring_boot_circuit_breaker_with_hystrix.exception.ServiceFailureException;

@Service
public class MyService {

	@HystrixCommand(fallbackMethod = "fallbackHello")
	// If we comment out the above line, the failure case will go to the
	// @ExceptionHandler(ServiceFailureException.class) in the RestExceptionHandler
	// class
	public String sayHello() {

		// Simulate a service call
		if (new Random().nextBoolean()) {

			throw new ServiceFailureException("Service call failed");

		}

		return "Hello from service";
	}

//	Ths syntax will not work well. It will show exception on the console, not on the browser
//	public String fallbackHello(Exception ex) {
//
//		return "Fallback response:" + ex.getMessage();
//
//	}

	public String fallbackHello() {

		return "Fallback response: fallbackHello() called";

	}
}
