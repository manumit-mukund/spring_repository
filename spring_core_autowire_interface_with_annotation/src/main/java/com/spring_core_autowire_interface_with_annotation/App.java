package com.spring_core_autowire_interface_with_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_core_autowire_interface_with_annotation.config.BeanConfig;
import com.spring_core_autowire_interface_with_annotation.service.ShapeService;

public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		ShapeService shapeService = (ShapeService) context.getBean(ShapeService.class);

		shapeService.drawShape();

	}
}
