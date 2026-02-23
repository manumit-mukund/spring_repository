package com.spring_async_service_multiple.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_async_service_multiple.service.AsyncService;

@RestController
public class AsyncController {

	private final AsyncService asyncService;

	public AsyncController(AsyncService asyncService) {

		this.asyncService = asyncService;

	}

	@GetMapping("/multi-async")
	public CompletableFuture<String> callMultipleAsync() {

		Instant startTime = Instant.now();
		System.out.println("Process started at: " + startTime);

		CompletableFuture<String> task1 = asyncService.asyncTaskOne();
		CompletableFuture<String> task2 = asyncService.asyncTaskTwo();
		CompletableFuture<String> task3 = asyncService.asyncTaskThree();

		Instant endTime = Instant.now();
		System.out.println("Process ended at: " + endTime);

		Duration timeElapsed = Duration.between(startTime, endTime);

		System.out.println("Total elapsed time in seconds: " + timeElapsed.getSeconds() + " s");

		// Combine all results once they are done
		return CompletableFuture.allOf(task1, task2, task3)
				.thenApply(v -> String.join(" | ", task1.join(), task2.join(), task3.join()));

		// Test url: http://localhost:9001/multi-async

	}
}