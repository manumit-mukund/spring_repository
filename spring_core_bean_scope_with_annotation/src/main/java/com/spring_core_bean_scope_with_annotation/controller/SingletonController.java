package com.spring_core_bean_scope_with_annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_core_bean_scope_with_annotation.service.SingletonService;

@RestController
public class SingletonController {

	@Autowired
	private SingletonService singletonService;

	@GetMapping("/singleton")
	public String useSingletonService() {

		singletonService.execute();
		return "Check the console for singleton service output.";

	}

}
