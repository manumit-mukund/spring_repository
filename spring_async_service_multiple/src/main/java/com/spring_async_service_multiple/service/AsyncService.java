package com.spring_async_service_multiple.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async
	public CompletableFuture<String> asyncTaskOne() {

		try {

			Thread.sleep(2000); // simulate delay

		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();

		}

		return CompletableFuture.completedFuture("Result from Task One");
	}

	@Async
	public CompletableFuture<String> asyncTaskTwo() {

		try {

			Thread.sleep(3000); // simulate delay

		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();

		}

		return CompletableFuture.completedFuture("Result from Task Two");
	}

	@Async
	public CompletableFuture<String> asyncTaskThree() {

		try {

			Thread.sleep(1000); // simulate delay

		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();

		}

		return CompletableFuture.completedFuture("Result from Task Three");
	}
}