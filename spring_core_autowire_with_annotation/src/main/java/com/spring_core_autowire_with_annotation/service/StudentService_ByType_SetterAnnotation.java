package com.spring_core_autowire_with_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring_core_autowire_with_annotation.model.Student;

public class StudentService_ByType_SetterAnnotation {

	private Student student;

	public StudentService_ByType_SetterAnnotation() {

		System.out.println("StudentService_ByType_SetterAnnotation() called...");

	}

	public StudentService_ByType_SetterAnnotation(Student student) {

		super();
		this.student = student;
		System.out.println("StudentService_ByType_SetterAnnotation(Student student) called...");
	}

	public Student getStudent() {
		return student;
	}

	@Autowired
	public void setStudent(Student student) {

		this.student = student;
		System.out.println("setStudent(Student student) called...");

	}

	public void printAge() {

		System.out.println("Age : " + student.getAge());

	}

	public void printName() {

		System.out.println("Name : " + student.getName());

	}
}
