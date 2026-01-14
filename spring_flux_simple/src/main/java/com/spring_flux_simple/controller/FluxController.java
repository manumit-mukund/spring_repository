package com.spring_flux_simple.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
		return Flux
				.just("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
				.delayElements(Duration.ofSeconds(2))
				.log();

	}

	@GetMapping(value = "/stream-items_1", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<String> streamItems_Without_Data_Prefix_1() {

		// Create a Flux that emits items "Item 1", "Item 2", "Item 3"
		// and introduces a delay of 1 second between each emission to simulate a
		// stream.
		return Flux
				.just("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
				.delayElements(Duration.ofSeconds(2))
				.log();

	}

	@GetMapping(value = "/stream-items_2", produces = MediaType.TEXT_PLAIN_VALUE)
	public Flux<String> streamItems_Without_Data_Prefix_2() {

		// Create a Flux that emits items "Item 1", "Item 2", "Item 3"
		// and introduces a delay of 1 second between each emission to simulate a
		// stream.
		return Flux
				.just("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
				.delayElements(Duration.ofSeconds(2)).log();

	}

	@GetMapping(value = "/delayed-items", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> getDelayedItems() {

		List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5");

		// Use the delayElements operator to introduce a 3-second delay between each
		// element
		return Flux
				.fromIterable(items)
				.delayElements(Duration.ofSeconds(3))
				.log(); // The .log() operator provides
																					// helpful logs to observe the
																					// emissions

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

	@GetMapping("/hello")
	public Mono<String> hello() {

		return Mono.just("Mono: Hello, World!"); // Returns a single, non-blocking response

	}
}
