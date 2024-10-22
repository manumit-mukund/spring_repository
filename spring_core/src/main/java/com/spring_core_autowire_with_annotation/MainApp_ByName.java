package com.spring_core_autowire_with_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_with_annotation.service.StudentService_ByName;

public class MainApp_ByName {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans_byName.xml");

		StudentService_ByName studentService = (StudentService_ByName) context.getBean("studentservice");
		studentService.printAge();
		studentService.printName();

	}
}
