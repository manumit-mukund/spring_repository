package com.user_service_db_csv_file.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.user_service_db_csv_file.entity.Employee;

@Component
public class CsvGeneratorUtil {

	private static final String CSV_HEADER = "ID,Name,Age,Designation,Salary\n";

	public String generateCsv(List<Employee> employees) {

		StringBuilder csvContent = new StringBuilder();
		csvContent.append(CSV_HEADER);

		for (Employee employee : employees) {

			csvContent.append(employee.getId()).append(",").append(employee.getName()).append(",")
					.append(employee.getAge()).append(",").append(employee.getDesignation()).append(",")
					.append(employee.getSalary()).append("\n");

		}

		return csvContent.toString();
	}
}
