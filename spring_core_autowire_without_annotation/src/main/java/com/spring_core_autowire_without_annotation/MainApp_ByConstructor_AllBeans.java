package com.spring_core_autowire_without_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_without_annotation.model.A;

public class MainApp_ByConstructor_AllBeans {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext_ByConstructor_AllBeans.xml");

		A a = context.getBean("a1", A.class);

		try {

			a.displayB(); // jjava.lang.NullPointerException: Cannot invoke
							// "com.spring_core_autowire_without_annotation.model.B.hello()" because
							// "this.b" is null
			a.displayC();

			a.displayD();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
