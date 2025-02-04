package com.spring_core_autowire_without_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_without_annotation.model.A;

public class MainApp_ByConstructor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_ByConstructor.xml");

		A a = context.getBean("a1", A.class);
		a.displayD();

		// a.displayB(); // java.lang.NullPointerException

		// a.displayC(); // java.lang.NullPointerException

	}
}
