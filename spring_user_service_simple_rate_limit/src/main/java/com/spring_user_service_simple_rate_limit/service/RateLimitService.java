package com.spring_user_service_simple_rate_limit.service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;

@Service
public class RateLimitService {

	private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

	public Bucket resolveBucket(String clientIp) {

		// Defines limit: 10 requests per minute
		Bandwidth limit = Bandwidth.classic(5, Refill.intervally(5, Duration.ofSeconds(1)));

		return buckets.computeIfAbsent(clientIp, ip -> Bucket.builder().addLimit(limit).build());
	}
}
