package com.spring_core_autowire_with_annotation.model;

public class Student {

	private Integer age;
	private String name;

	public Student() {

		super();
		System.out.println("Student() called...");

	}

	public void setAge(Integer age) {

		this.age = age;

	}

	public Integer getAge() {

		return age;

	}

	public void setName(String name) {

		this.name = name;
	}

	public String getName() {

		return name;

	}
}