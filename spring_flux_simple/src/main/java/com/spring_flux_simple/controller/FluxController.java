package com.spring_flux_simple.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RestController
public class FluxController {

	/**
	 * An endpoint that returns a stream of strings with a 1-second delay between
	 * each item. The 'produces = MediaType.TEXT_EVENT_STREAM_VALUE' is key for
	 * streaming data incrementally.
	 */
	@GetMapping(value = "/stream-items", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> streamItems() {

		// Create a Flux that emits items "Item 1", "Item 2", "Item 3"
		// and introduces a delay of 1 second between each emission to simulate a
		// stream.
		return Flux.just("Item 1", "Item 2", "Item 3", "Item 4", "Item 5").delayElements(Duration.ofSeconds(3)).log();

	}

	/**
	 * An endpoint that returns a standard JSON array (all at once) containing the
	 * same items.
	 */
	@GetMapping("/items")
	public Flux<String> getItems() {

		// This endpoint will gather all items and return a complete JSON array.
		return Flux.just("Item 1", "Item 2", "Item 3", "Item 4", "Item 5");

	}
}
