package com.spring_core_autowire_without_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_without_annotation.model.A;

public class MainApp_ByName {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_ByName.xml");

		A a = context.getBean("a1", A.class);

		a.displayB();

		// a.displayC(); // java.lang.NullPointerException

		// a.displayD(); // java.lang.NullPointerException

	}
}
