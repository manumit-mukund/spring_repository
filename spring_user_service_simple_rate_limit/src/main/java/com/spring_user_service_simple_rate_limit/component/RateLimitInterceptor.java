package com.spring_user_service_simple_rate_limit.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.spring_user_service_simple_rate_limit.service.RateLimitService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

	private final RateLimitService rateLimitService;

	public RateLimitInterceptor(RateLimitService rateLimitService) {

		this.rateLimitService = rateLimitService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		if (rateLimitService.resolveBucket(request.getRemoteAddr()).tryConsume(1))

			return true;

		response.setStatus(429);

		return false;
	}
}
