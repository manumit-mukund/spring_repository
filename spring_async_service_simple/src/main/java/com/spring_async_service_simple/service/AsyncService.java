package com.spring_async_service_simple.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async
	public CompletableFuture<String> asyncMethod() {

		try {
			
			System.out.println("Thread is sleeping...");

			Thread.sleep(3000); // simulate long-running task
			
			System.out.println("Thread is awake...");

		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();

		}

		return CompletableFuture.completedFuture("Task completed!");
	}
}