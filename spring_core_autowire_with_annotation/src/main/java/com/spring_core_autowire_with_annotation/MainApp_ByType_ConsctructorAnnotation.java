package com.spring_core_autowire_with_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_with_annotation.service.StudentService_ByType_ConsctructorAnnotation;

public class MainApp_ByType_ConsctructorAnnotation {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans_byType_ConsctructorAnnotation.xml");

		StudentService_ByType_ConsctructorAnnotation studentService = (StudentService_ByType_ConsctructorAnnotation) context
				.getBean("studentservice");
		studentService.printAge();
		studentService.printName();

	}
}
