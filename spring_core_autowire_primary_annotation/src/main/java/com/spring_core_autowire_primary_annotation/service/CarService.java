package com.spring_core_autowire_primary_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_core_autowire_primary_annotation.component.Car;

@Service
public class CarService {

	@Autowired
	Car car;

	public void setCar(Car car) {

		this.car = car;

	}

	public Car getCar() {

		return car;

	}

}
