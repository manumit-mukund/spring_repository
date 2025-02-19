package com.spring_core_bean_scope_with_annotation_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
public class RequestScopeController {

	@GetMapping("message")
	public String getMessage() {

		System.out.println("\n" + this);
		return "Hello from RequestScopeController";

	}
}
