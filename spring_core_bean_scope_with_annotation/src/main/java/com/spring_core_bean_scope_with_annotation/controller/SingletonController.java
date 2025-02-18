package com.spring_core_bean_scope_with_annotation.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_core_bean_scope_with_annotation.component.SingletonBean;

@RestController
public class SingletonController {

	@Autowired
	private ApplicationContext context;

	@GetMapping("/singleton")
	public String usePrototype() {

		SingletonBean singletonBean = context.getBean(SingletonBean.class);

		singletonBean.setState("Updated State at " + new Date());
		System.out.println("\nSingletonBean State fetched first time:  = " + singletonBean.getState());

		singletonBean = context.getBean(SingletonBean.class);
		System.out.println("\nSingletonBean State fetched second time:  = " + singletonBean.getState());

		return "singletonBean Bean State retuned: " + singletonBean.getState();

	}
}
