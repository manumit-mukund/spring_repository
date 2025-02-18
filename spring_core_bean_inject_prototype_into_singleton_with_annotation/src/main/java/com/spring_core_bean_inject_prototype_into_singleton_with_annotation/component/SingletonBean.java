package com.spring_core_bean_inject_prototype_into_singleton_with_annotation.component;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {

	@Autowired
	private PrototypeBean prototypeBean;

	public SingletonBean() {

		System.out.println("singleton instance created....");

	}

	public PrototypeBean getPrototypeBean() {

		System.out.println("\ngetPrototypeBean() called at: " + LocalDateTime.now());

		return prototypeBean;

	}
}