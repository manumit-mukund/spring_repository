package com.spring_core_bean_lifecycle.beans;

public class HelloWorld {

	public void init() {

		System.out.println("Bean initialized using XML");

	}

	public void destroy() {

		System.out.println("Bean destroyed using XML");

	}
}