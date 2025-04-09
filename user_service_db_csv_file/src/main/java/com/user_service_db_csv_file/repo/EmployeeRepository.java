package com.user_service_db_csv_file.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service_db_csv_file.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
