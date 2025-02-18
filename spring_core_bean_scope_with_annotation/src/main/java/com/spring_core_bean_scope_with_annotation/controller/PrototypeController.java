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

		PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);	
		
		prototypeBean.setState("Updated State at " + new Date());		
		System.out.println("\nPrototype Bean State fetched first time:  = " + prototypeBean.getState());
		
		prototypeBean = context.getBean(PrototypeBean.class);	
		System.out.println("\nPrototype Bean State fetched second time:  = " + prototypeBean.getState());
		
		return "Prototype Bean State retuned: " + prototypeBean.getState();

	}
}
