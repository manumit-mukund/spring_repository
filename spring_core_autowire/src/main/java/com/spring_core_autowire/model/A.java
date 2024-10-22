package com.spring_core_autowire.model;

public class A {

	B b;
	C c;
	D d;

	A() {

		System.out.println("A is created");
	}

	A(D d) {

		this.d = d;
		System.out.println("A(D d) is called");
	}

	public B getB() {

		return b;

	}

	public void setB(B b) {

		this.b = b;
		System.out.println("setB(B b) is called");

	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		
		this.c = c;
		System.out.println("setC(C c) is called");
	}

	public void displayB() {

		b.hello();

	}

	public void displayC() {

		c.hello();

	}

	public void displayD() {

		d.hello();

	}
}
