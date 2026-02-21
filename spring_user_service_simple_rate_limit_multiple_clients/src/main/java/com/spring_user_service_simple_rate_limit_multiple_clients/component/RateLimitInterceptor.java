package com.spring_user_service_simple_rate_limit_multiple_clients.component;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.spring_user_service_simple_rate_limit_multiple_clients.service.RateLimitService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

	private final RateLimitService rateLimitService;

	public RateLimitInterceptor(RateLimitService rateLimitService) {

		this.rateLimitService = rateLimitService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException, ServletException {

		String apiKey = request.getHeader("X-API-KEY");

		if (apiKey == null || apiKey.isEmpty()) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Missing API Key");
			
			return false;
		}

		if (rateLimitService.resolveBucket(apiKey).tryConsume(1))

			return true;

		response.setStatus(429);

		return false;
	}
}
