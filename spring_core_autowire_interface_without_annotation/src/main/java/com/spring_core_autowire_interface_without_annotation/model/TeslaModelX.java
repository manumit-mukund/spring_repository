package com.spring_core_autowire_interface_without_annotation.model;

public class TeslaModelX {

	private Motor motor;

	public TeslaModelX(Motor electricMotor1) {

		motor = electricMotor1;

	}

//	If we comment out the above constructor and uncomment this one, the output will change

//	public TeslaModelX(Motor electricMotor2) {
//
//		motor = electricMotor2;
//
//	}

	public void goForward() {

		motor.start();

		System.out.println("Going Forward.");

	}

}
