package com.spring_core_autowire_primary_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring_core_autowire_primary_annotation.service.CarService;

//@Configuration //It's optional;
@ComponentScan(basePackages = { "com.spring_core_autowire_primary_annotation.component",
		"com.spring_core_autowire_primary_annotation.service" })
public class SpringPrimaryAnnotationExample {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringPrimaryAnnotationExample.class);

		CarService carService1 = (CarService) ctx.getBean("carService");

		// carService1.printCarName(); //The method printCarName() is undefined for the
		// type CarService

		carService1.getCar().printCarName();

	}

}
