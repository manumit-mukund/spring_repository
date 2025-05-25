package com.spring_boot_redis_session_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/redis")
public class SessionController {

	@GetMapping("/session")
	public String manageSession(HttpSession session) {

		String sessionId = session.getId();
		String attribute = (String) session.getAttribute("myAttribute");

		if (attribute == null) {

			session.setAttribute("myAttribute", "Hello from Session!");
			attribute = (String) session.getAttribute("myAttribute");

		}

		return "Session ID: " + sessionId + ", Attribute: " + attribute;
	}
}