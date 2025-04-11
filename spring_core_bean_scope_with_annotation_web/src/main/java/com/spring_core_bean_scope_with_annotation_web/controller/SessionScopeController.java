package com.spring_core_bean_scope_with_annotation_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
public class SessionScopeController {

	@GetMapping("/session-scope")
	public String getMessage() {

		System.out.println("\n" + this);
		
		return "Hello from SessionScopeController";

	}
}