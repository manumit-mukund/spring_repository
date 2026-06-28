package com.spring_boot_async_service_multiple.service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	@Autowired
	private AsyncService asyncService;

	public CompletableFuture<String> executeTasks() throws Exception {

		Instant startTime = Instant.now();
		System.out.println("Process started at: " + startTime);

		CompletableFuture<String> completableFuture1 = asyncService.asyncTaskOne();
		CompletableFuture<String> completableFuture2 = asyncService.asyncTaskTwo();
		CompletableFuture<String> completableFuture3 = asyncService.asyncTaskThree();

		// Wait for all tasks to complete
		CompletableFuture<Void> allTasks = CompletableFuture.allOf(completableFuture1, completableFuture2,
				completableFuture3);

		allTasks.join();

		System.out.println("completableFuture1.join() = " + completableFuture1.join());
		System.out.println("completableFuture1.get() = " + completableFuture1.get());
		System.out.println("completableFuture2.get() = " + completableFuture2.get());
		System.out.println("completableFuture3.get() = " + completableFuture3.get());

		Instant endTime = Instant.now();
		System.out.println("Process ended at: " + endTime);

		Duration timeElapsed = Duration.between(startTime, endTime);

		System.out.println("Total elapsed time in seconds: " + timeElapsed.getSeconds() + " s");

		// Combine all results once they are done
		return CompletableFuture.completedFuture("All the three tasks completed!");

	}
}
