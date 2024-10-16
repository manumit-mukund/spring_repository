package com.spring_core_autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire.model.A;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		A a = context.getBean("a", A.class);
		a.displayB();

		A a1 = context.getBean("a1", A.class);
		a1.displayC();

		A a2 = context.getBean("a2", A.class);
		a2.displayD();

	}
}
