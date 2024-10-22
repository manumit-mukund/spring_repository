package com.spring_core_autowire_primary_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	Car car;

	public Car getCar() {

		return car;

	}

	public void setCar(Car car) {

		this.car = car;

	}

}
