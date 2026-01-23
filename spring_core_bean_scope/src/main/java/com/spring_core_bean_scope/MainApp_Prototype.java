package com.spring_core_bean_scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_bean_scope.model.HelloWorld;

public class MainApp_Prototype {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_prototype.xml");

		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();

		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		objB.getMessage();
	}
}