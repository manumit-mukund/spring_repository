package com.spring_boot_redis_session_management_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/redis")
public class SessionController {

	@GetMapping("/session/set")
	public String setSession(HttpSession session) {

		// String sessionId = session.getId();

		String sessionId = "";
		String username = "";

		if (session.isNew()) {

			sessionId = "New session created: " + session.getId();

			session.setAttribute("username", "Manu");
			username = (String) session.getAttribute("username");

		} else {

			sessionId = "Existing session accessed: " + session.getId();
			username = (String) session.getAttribute("username");
		}

		return "Session ID: " + sessionId + ", username: " + username;

		// Test url: http://localhost:9001/redis/session/set
	}

	@GetMapping("/session/get")
	public String getSession(HttpServletRequest request) {

		HttpSession session = request.getSession(false); // Get existing session, don't create new if none exists

		String sessionId = "Session ID not found, session is new";
		String username = "username not found";

		if (session != null) {

			sessionId = session.getId();
			username = (String) session.getAttribute("username");

		}

		return "Session ID: " + sessionId + ", username: " + username;

		// Test url: http://localhost:9001/redis/session/get
	}

	@GetMapping("/session/invalidate")
	public String invalidateSession(HttpSession session) {

		session.invalidate();

		String sessionInvalidated = "session invalidated";

		return sessionInvalidated;

		// Test url: http://localhost:9001/redis/session/invalidate
	}
}