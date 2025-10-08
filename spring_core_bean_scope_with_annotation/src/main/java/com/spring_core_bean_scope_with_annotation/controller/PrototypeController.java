package com.spring_core_bean_scope_with_annotation.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_core_bean_scope_with_annotation.component.PrototypeBean;

@RestController
public class PrototypeController {

	@Autowired
	private ApplicationContext context;

	@GetMapping("/prototype")
	public String usePrototype() {

		PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);

		System.out.println("\nsingletonBean1.getState()  = " + prototypeBean1.getState());

		prototypeBean1.setState("Updated State at " + new Date());

		System.out.println("\nprototypeBean1.getState()  = " + prototypeBean1.getState());

		PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);

		System.out.println("\nprototypeBean2.getState()  = " + prototypeBean2.getState());

		return "returned prototypeBean2.getState() =" + prototypeBean2.getState();

	}
}
