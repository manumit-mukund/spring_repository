package com.spring_core_autowire_abstract_class_with_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_core_autowire_abstract_class_with_annotation.config.BeanConfig;
import com.spring_core_autowire_abstract_class_with_annotation.service.ShapeService;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		ShapeService shapeService = (ShapeService) context.getBean(ShapeService.class);

		shapeService.drawShape();

	}
}
