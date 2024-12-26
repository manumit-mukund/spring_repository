package com.spring_core_lambok_builder;

import com.spring_core_lambok_builder.model.Employee;

class LombokTest {

	public static void main(String[] args) {

		Employee employee1 = Employee
				.builder()
				.employeeId(1)
				.name("E1")
				.company("C1")
				.emailId("abc@yahoo.com")
				.build();

		System.out.println("employee1 = " + employee1);
		
		Employee employee2 = Employee
				.builder()
				.employeeId(2)
				.name("E2")
				.company("C2")			
				.build();

		System.out.println("employee2 = " + employee2);

	}
}