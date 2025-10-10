package com.spring_core_autowire_without_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_without_annotation.model.A;

public class MainApp_ByConstructor_OneBean {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_ByConstructor_OneBean.xml");

		A a = context.getBean("a1", A.class);

		a.displayB();

		// a.displayC(); // Exception in thread "main" java.lang.NullPointerException:
		// Cannot invoke
		// "com.spring_core_autowire_without_annotation.model.C.hello()" because
		// "this.c" is null

		// a.displayD();

	}
}
