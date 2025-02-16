package com.spring_core_bean_scope_with_annotation.service;

import org.springframework.stereotype.Service;

@Service
public class SingletonService {

	public void execute() {

		System.out.println("Executing Singleton Service");

	}

}
