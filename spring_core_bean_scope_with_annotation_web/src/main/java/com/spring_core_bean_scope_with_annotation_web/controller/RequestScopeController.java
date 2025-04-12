package com.spring_core_bean_scope_with_annotation_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
//@Scope("request")//This will also work fine
@RequestScope
public class RequestScopeController {

	@GetMapping("request-scope")
	public String getMessage() {

		System.out.println("\n" + this);

		return "Hello from RequestScopeController";

	}
}
