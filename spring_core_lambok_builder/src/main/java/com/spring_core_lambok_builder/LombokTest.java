package com.spring_core_lambok_builder;

import com.spring_core_lambok_builder.model.Employee;

class LombokTest {

	public static void main(String[] args) {

		Employee employee = Employee
				.builder()
				.employeeId(21)
				.name("E1")
				.company("C1")
				.emailId("abc@yahoo.com")
				.build();

		System.out.println("employee = " + employee);

	}
}