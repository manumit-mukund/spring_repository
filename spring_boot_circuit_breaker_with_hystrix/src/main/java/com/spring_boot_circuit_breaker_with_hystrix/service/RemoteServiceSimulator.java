package com.spring_boot_circuit_breaker_with_hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RemoteServiceSimulator implements RemoteService {

	@HystrixCommand(fallbackMethod = "reliable")
	public String callService() throws InterruptedException {

		if (new Random().nextBoolean()) {

			throw new RuntimeException("Service Failure!");

		}

		return "Successfully called service!";
	}

	public String reliable() {

		return "Default Response";

	}
}