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

			a.displayC(); // java.lang.NullPointerException, if will work if only c is defined in .xml
							// file

			a.displayD(); // Sometimes it will work fine, and at other times it will show error:
							// java.lang.NullPointerException: Cannot invoke
							// "com.spring_core_autowire_without_annotation.model.D.hello()" because
							// "this.d"

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
