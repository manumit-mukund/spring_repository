package com.spring_core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring_core.model.Student;

public class StudentService {

	@Autowired
	@Qualifier("student2")
	private Student student;

	public StudentService() {

		System.out.println("Inside StudentService constructor.");

	}

	public void printAge() {

		System.out.println("Age : " + student.getAge());

	}

	public void printName() {

		System.out.println("Name : " + student.getName());

	}
}
