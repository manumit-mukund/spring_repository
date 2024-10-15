package com.spring_core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core.service.StudentService;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		StudentService studentService = (StudentService) context.getBean("studentservice");
		studentService.printAge();
		studentService.printName();

	}
}
