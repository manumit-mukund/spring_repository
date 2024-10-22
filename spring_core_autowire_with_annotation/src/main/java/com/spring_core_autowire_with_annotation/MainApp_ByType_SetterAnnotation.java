package com.spring_core_autowire_with_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_with_annotation.service.StudentService_ByType_SetterAnnotation;

public class MainApp_ByType_SetterAnnotation {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans_byType_SetterAnnotation.xml");

		StudentService_ByType_SetterAnnotation studentService = (StudentService_ByType_SetterAnnotation) context
				.getBean("studentservice");
		studentService.printAge();
		studentService.printName();

	}
}
