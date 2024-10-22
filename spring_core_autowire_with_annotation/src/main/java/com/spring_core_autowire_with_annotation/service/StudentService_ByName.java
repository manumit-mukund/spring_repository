package com.spring_core_autowire_with_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring_core_autowire_with_annotation.model.Student;

public class StudentService_ByName {

	@Autowired
	@Qualifier("student2")
	private Student student;

	public StudentService_ByName() {

		System.out.println("StudentService_ByName() called...");

	}

	public StudentService_ByName(Student student) {

		super();
		this.student = student;
		System.out.println("StudentService_ByName(Student student) called...");
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
