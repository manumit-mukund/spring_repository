package com.spring_core_autowire_without_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_without_annotation.model.A;

public class MainApp_ByConstructor_TwoBeans {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext_ByConstructor_TwoBeans.xml");

		A a = context.getBean("a1", A.class);

		try {

			a.displayC();

			a.displayB();
//			java.lang.NullPointerException: Cannot invoke "com.spring_core_autowire_without_annotation.model.B.hello()" because "this.b" is null
//			at com.spring_core_autowire_without_annotation.model.A.displayB(A.java:66)
//			at com.spring_core_autowire_without_annotation.MainApp_ByConstructor_TwoBeans.main(MainApp_ByConstructor_TwoBeans.java:19)

			a.displayD();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
