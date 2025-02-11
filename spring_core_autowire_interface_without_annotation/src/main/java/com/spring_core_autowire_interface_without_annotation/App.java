package com.spring_core_autowire_interface_without_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_interface_without_annotation.model.TeslaModelX;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

		TeslaModelX modelX = (TeslaModelX) context.getBean("modelX");

		modelX.goForward();

	}
}
