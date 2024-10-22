package com.spring_core_autowire_primary_annotation.service;

import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Component;

@Component
@Primary
public class Ferrari implements Car {

	public void printCarName() {

		System.out.println("Ferrari");

	}

}
