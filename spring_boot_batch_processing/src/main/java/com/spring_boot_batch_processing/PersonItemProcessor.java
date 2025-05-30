package com.spring_boot_batch_processing;

import org.springframework.batch.item.ItemProcessor;

import com.spring_boot_batch_processing.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person person) throws Exception {
		
		String firstName = person.getFirstName().toUpperCase();
		String lastName = person.getLastName().toUpperCase();

		return new Person(firstName, lastName);
	}
}