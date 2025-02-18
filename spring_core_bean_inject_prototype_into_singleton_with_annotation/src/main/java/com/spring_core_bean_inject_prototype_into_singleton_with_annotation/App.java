package com.spring_core_bean_inject_prototype_into_singleton_with_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_core_bean_inject_prototype_into_singleton_with_annotation.component.PrototypeBean;
import com.spring_core_bean_inject_prototype_into_singleton_with_annotation.component.SingletonBean;
import com.spring_core_bean_inject_prototype_into_singleton_with_annotation.config.BeanApp;

public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanApp.class);

		SingletonBean s1 = context.getBean(SingletonBean.class);
		PrototypeBean p1 = s1.getPrototypeBean();
		p1.setState("Hello World");
		System.out.println("\np1.getState() = " + p1.getState());

		SingletonBean s2 = context.getBean(SingletonBean.class);
		PrototypeBean p2 = s2.getPrototypeBean();
		System.out.println("\np2.getState() = " + p2.getState());

		System.out.println("\n(p1 == p2) : " + (p1 == p2));

	}

}
