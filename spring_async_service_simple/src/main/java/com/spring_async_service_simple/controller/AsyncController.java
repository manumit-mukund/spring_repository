package com.spring_async_service_simple.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_async_service_simple.service.AsyncService;

@RestController
public class AsyncController {

	private final AsyncService asyncService;

	public AsyncController(AsyncService asyncService) {

		this.asyncService = asyncService;

	}

	@GetMapping("/async-call")
	public CompletableFuture<String> makeAsyncCall() {

		return asyncService.asyncMethod();

	}
}
