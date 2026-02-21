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

	private final Map<String, Bucket> bucketMap = new ConcurrentHashMap<>();

	public Bucket resolveBucket(String clientIp) {

		// Defines limit: 6 requests per second
		Bandwidth limit = Bandwidth.classic(6, Refill.intervally(6, Duration.ofSeconds(1)));

		return bucketMap.computeIfAbsent(clientIp, ip -> Bucket.builder().addLimit(limit).build());
	}
}
