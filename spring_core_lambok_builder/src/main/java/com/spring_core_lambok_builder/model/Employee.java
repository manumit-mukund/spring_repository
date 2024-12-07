package com.spring_core_lambok_builder.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {

	private Integer employeeId;

	private String name;

	private String company;

	private String emailId;

}