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

			a.displayD();

			a.displayB();
//			java.lang.NullPointerException: Cannot invoke "com.spring_core_autowire_without_annotation.model.B.hello()" because "this.b" is null
//			at com.spring_core_autowire_without_annotation.model.A.displayB(A.java:66)
//			at com.spring_core_autowire_without_annotation.MainApp_ByConstructor_AllBeans.main(MainApp_ByConstructor_AllBeans.java:19)
			// as two constructors cannot be called together.
			a.displayC();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
