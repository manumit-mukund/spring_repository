package com.spring_core_autowire_without_annotation.model;

public class A {

	B b;
	C c;
	D d;

	A() {

		System.out.println("A is created");
	}

	A(B b) {

		this.b = b;
		System.out.println("A(B b) is called");
	}

	A(C c) {

		this.c = c;
		System.out.println("A(C c) is called");
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

	public D getD() {
		return d;
	}

	public void setD(D d) {
		this.d = d;
		System.out.println("setD(D d) is called");
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
