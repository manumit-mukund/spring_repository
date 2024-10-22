package com.spring_core_autowire_with_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring_core_autowire_with_annotation.model.Student;

public class StudentService_ByName_ConsctructorAnnotation {

	private Student student;

	public StudentService_ByName_ConsctructorAnnotation() {

		super();
		System.out.println("StudentService_ByName_ConsctructorAnnotation() called...");

	}

	@Autowired
	public StudentService_ByName_ConsctructorAnnotation(@Qualifier("student2") Student student) {

		super();
		this.student = student;
		System.out.println("StudentService_ByName_ConsctructorAnnotation(Student student) called...");
	}

	public Student getStudent() {

		return student;

	}

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
