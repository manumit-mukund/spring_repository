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

		session.setAttribute("myAttribute", "Manu");

		return "Session attribute set";
	}

	@GetMapping("/get")
	public String getSession(HttpSession session) {

		return (String) session.getAttribute("myAttribute");

	}
}