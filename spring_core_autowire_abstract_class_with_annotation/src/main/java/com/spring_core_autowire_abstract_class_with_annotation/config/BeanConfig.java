package com.spring_core_autowire_abstract_class_with_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring_core_autowire_abstract_class_with_annotation.model.Circle;

@Configuration
@ComponentScan(basePackages = { "com.spring_core_autowire_abstract_class_with_annotation.model",
		"com.spring_core_autowire_abstract_class_with_annotation.service" })
public class BeanConfig {

//	If we want to use Square, we'll have to comment out the Circle bean
//	@Bean
//	Square mySquare() {
//
//		return new Square();
//
//	}

	@Bean
	Circle myCircle() {

		return new Circle();

	}

}
