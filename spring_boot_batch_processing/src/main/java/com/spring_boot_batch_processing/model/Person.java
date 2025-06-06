package com.spring_boot_batch_processing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Getters and Setters
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;

	}

//	@Override
//	public String toString() {
//
//		return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
//
//	}
}