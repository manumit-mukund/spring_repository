package com.spring_core_autowire_without_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_without_annotation.model.A;

public class MainApp_ByType {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_ByType.xml");

		A a1 = context.getBean("a1", A.class);

		a1.displayB();

		a1.displayC();

		a1.displayD();

	}
}
