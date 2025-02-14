package com.spring_core_autowire_qualifier_annotation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {

	@Autowired
	@Qualifier("student1")
	private Student student;

	public Profile() {

		System.out.println("Inside Profile constructor\n");

	}

	public void printName() {

		System.out.println("Name : " + student.getName());

	}

	public void printAge() {

		System.out.println("Age : " + student.getAge());

	}
}
