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

		SingletonBean singletonBean1 = context.getBean(SingletonBean.class);

		System.out.println("\nsingletonBean1.getState()  = " + singletonBean1.getState());

		singletonBean1.setState("Updated State at " + new Date());

		System.out.println("\nsingletonBean1.getState()  = " + singletonBean1.getState());

		SingletonBean singletonBean2 = context.getBean(SingletonBean.class);

		System.out.println("\nsingletonBean2.getState()  = " + singletonBean2.getState());

		return "returned singletonBean2.getState() =" + singletonBean2.getState();

	}
}
