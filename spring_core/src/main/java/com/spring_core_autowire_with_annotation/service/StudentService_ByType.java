package com.spring_core_autowire_with_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring_core_autowire_with_annotation.model.Student;

public class StudentService_ByType {

	@Autowired
	private Student student;

	public StudentService_ByType() {

		System.out.println("StudentService_ByName() called...");

	}

	public void printAge() {

		System.out.println("Age : " + student.getAge());

	}

	public void printName() {

		System.out.println("Name : " + student.getName());

	}
}
