package com.spring_user_service_simple_rate_limit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring_user_service_simple_rate_limit.component.RateLimitInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	private final RateLimitInterceptor rateLimitInterceptor;

	@Autowired
	public MvcConfig(RateLimitInterceptor rateLimitInterceptor) {
		this.rateLimitInterceptor = rateLimitInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// Register the interceptor and apply it to specific path patterns
		registry.addInterceptor(rateLimitInterceptor).addPathPatterns("/users/**"); // Apply rate limiting to all paths
																					// under /api/
	}
}
