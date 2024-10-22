package com.spring_core_autowire_with_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_with_annotation.service.StudentService_ByType;

public class MainApp_ByType {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans_byType.xml");

		StudentService_ByType studentService = (StudentService_ByType) context.getBean("studentservice");
		studentService.printAge();
		studentService.printName();

	}
}
