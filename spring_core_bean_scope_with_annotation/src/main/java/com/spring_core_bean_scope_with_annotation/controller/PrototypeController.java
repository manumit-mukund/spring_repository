package com.spring_core_bean_scope_with_annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

import com.spring_core_bean_scope_with_annotation.component.PrototypeBean;

@RestController
public class PrototypeController {

	@Autowired
	private ApplicationContext context;

	@GetMapping("/prototype")
	public String usePrototype() {

		PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
		prototypeBean.setState("Updated State at " + new Date());
		
		return "Prototype Bean State: " + prototypeBean.getState();

	}
}
