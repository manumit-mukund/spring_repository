package com.spring_core_autowire.model;

public class A {

	B b;
	C c;
	D d;

	A() {

		System.out.println("A() is called");
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

	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
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
