package com.spring_boot_jdbc_session_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/jdbc")
public class MyController {

	@GetMapping("/set")
	public String setSession(HttpSession session) {

		session.setAttribute("myAttribute1", "Manu1");
		session.setAttribute("myAttribute2", "Manu2");
		session.setAttribute("myAttribute3", "Manu3");

		return "Session attribute set";

		// Test url: http://localhost:9001/jdbc/set
	}

	@GetMapping("/get")
	public String getSession(HttpSession session) {

		String attributes = "";

		attributes += session.getAttribute("myAttribute1");
		attributes += ", " + session.getAttribute("myAttribute2");
		attributes += ", " + session.getAttribute("myAttribute3");

		return attributes;

		// Test url: http://localhost:9001/jdbc/get

	}
}