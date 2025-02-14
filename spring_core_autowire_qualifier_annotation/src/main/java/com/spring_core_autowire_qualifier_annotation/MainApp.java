package com.spring_core_autowire_qualifier_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_core_autowire_qualifier_annotation.model.Profile;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		Profile profile = (Profile) context.getBean("profile");

		profile.printName();
		profile.printAge();

	}
}
