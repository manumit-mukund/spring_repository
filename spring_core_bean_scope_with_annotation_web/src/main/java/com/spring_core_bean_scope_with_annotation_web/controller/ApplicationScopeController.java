package com.spring_core_bean_scope_with_annotation_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_core_bean_scope_with_annotation_web.component.ApplicationScopedBean;

@RestController
public class ApplicationScopeController {

	@Autowired
	private ApplicationScopedBean applicationScopedBean;

	@GetMapping("/application-scope")
	public String getApplicationScope() {

		System.out.println("\n" + this);

		return "Application Scoped Data: " + applicationScopedBean.getAppData();

	}
}
