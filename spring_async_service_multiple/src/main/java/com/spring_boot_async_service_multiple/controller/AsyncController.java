package com.spring_boot_async_service_multiple.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_async_service_multiple.service.AsyncService;

@RestController
public class AsyncController {

	private final AsyncService asyncService;

	public AsyncController(AsyncService asyncService) {

		this.asyncService = asyncService;

	}

	@GetMapping("/multi-async")
	public CompletableFuture<String> callMultipleAsync() {

		long startTime = System.currentTimeMillis();
		System.out.println("Process started at: " + startTime);

		CompletableFuture<String> task1 = asyncService.asyncTaskOne();
		CompletableFuture<String> task2 = asyncService.asyncTaskTwo();
		CompletableFuture<String> task3 = asyncService.asyncTaskThree();

		CompletableFuture<Void> completableFutureAllResult = CompletableFuture.allOf(task1, task2, task3);

		// Combine all results once they are done
		CompletableFuture<String> finalresult = completableFutureAllResult
				.thenApply(v -> String.join(" | ", task1.join(), task2.join(), task3.join()));

		long endTime = System.currentTimeMillis();
		System.out.println("Process ended at: " + startTime);

		long duration = endTime - startTime;

		System.out.println("Total elapsed time in seconds: " + duration + " milliseconds");

		return finalresult;

		// Test url: http://localhost:9001/multi-async

	}
}