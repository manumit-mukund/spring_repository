package com.spring_boot_async_service_multiple.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_async_service_multiple.service.MainService;

@RestController
public class AsyncController {

	private final MainService mainService;

	public AsyncController(MainService mainService) {

		this.mainService = mainService;

	}

	@GetMapping("/multi-async")
	public CompletableFuture<String> callMultipleAsync() throws Exception {

		return mainService.executeTasks();

		// Test url: http://localhost:9001/multi-async

	}
}

//@GetMapping("/multi-async")
//public CompletableFuture<String> callMultipleAsync() {

//	// Combine all results once they are done
//	return CompletableFuture.allOf(task1, task2, task3)
//			.thenApply(v -> String.join(" | ", task1.join(), task2.join(), task3.join()));

//
//}