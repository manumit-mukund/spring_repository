package com.spring_core_autowire.model;

public class A {

	B b1;

	A() {

		System.out.println("a is created");
	}

	public B getB() {

		return b1;

	}

	public void setB(B b) {

		this.b1 = b;

	}

	void print() {

		System.out.println("hello a");

	}

	public void display() {

		print();
		b1.print();

	}
}
