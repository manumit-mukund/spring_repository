package com.spring_core_autowire_primary_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

import com.spring_core_autowire_primary_annotation.service.CarService;

@Configuration
@ComponentScan(basePackages = { "com.spring_core_autowire_primary_annotation.service" })
public class SpringPrimaryAnnotationExample {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(

				SpringPrimaryAnnotationExample.class);

		CarService carService = (CarService) ctx.getBean("carService");

		carService.getCar().printCarName();

	}

}
