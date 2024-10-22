package com.spring_core_autowire_with_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_with_annotation.service.StudentService_ByName_ConsctructorAnnotation;

public class MainApp_ByName_ConsctructorAnnotation {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans_byName_ConsctructorAnnotation.xml");

		StudentService_ByName_ConsctructorAnnotation studentService = (StudentService_ByName_ConsctructorAnnotation) context
				.getBean("studentservice");
		studentService.printAge();
		studentService.printName();

	}
}
