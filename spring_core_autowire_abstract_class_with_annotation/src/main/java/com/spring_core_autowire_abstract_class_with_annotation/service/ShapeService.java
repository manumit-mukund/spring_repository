package com.spring_core_autowire_abstract_class_with_annotation.service;

import org.springframework.stereotype.Service;

import com.spring_core_autowire_abstract_class_with_annotation.model.Shape;

//@Component // -- This will also work fine
@Service
public class ShapeService {

	private Shape shape;

	public ShapeService(Shape shape) {

		this.shape = shape;

	}

	public void drawShape() {

		if (shape != null) {

			shape.draw();

		} else {

			System.out.println("No shape set.");

		}
	}
}
