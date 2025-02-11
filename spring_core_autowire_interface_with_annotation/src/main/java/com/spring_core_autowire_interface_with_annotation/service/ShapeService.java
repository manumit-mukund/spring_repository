package com.spring_core_autowire_interface_with_annotation.service;

import org.springframework.stereotype.Component;

import com.spring_core_autowire_interface_with_annotation.model.Shape;

@Component
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
