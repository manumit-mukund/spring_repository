package com.spring_core_autowire_qualifier_annotation.model;

public class Student {

	private String name;
	private Integer age;

	public Student() {

		super();

		System.out.println("Inside Student() constructor\n");
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
