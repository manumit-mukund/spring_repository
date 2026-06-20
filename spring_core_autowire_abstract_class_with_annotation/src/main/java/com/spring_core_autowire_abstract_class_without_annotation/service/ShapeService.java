package com.spring_core_autowire_abstract_class_without_annotation.service;

import org.springframework.stereotype.Service;

import com.spring_core_autowire_abstract_class_without_annotation.component.Shape;

//@Component // -- This will also work fine
@Service // One of the annotations is a must
public class ShapeService {

	private Shape shape;

	public ShapeService(Shape shape) {

		this.shape = shape;

		System.out.println("ShapeService(Shape shape) called...");

	}

	public void drawShape() {

		if (shape != null) {

			shape.draw();

		} else {

			System.out.println("No shape set.");

		}
	}
}
