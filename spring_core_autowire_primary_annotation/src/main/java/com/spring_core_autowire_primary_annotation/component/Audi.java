package com.spring_core_autowire_primary_annotation.component;

import org.springframework.stereotype.Component;

@Component
public class Audi implements Car {

	public void printCarName() {

		System.out.println("Audi");

	}

}
