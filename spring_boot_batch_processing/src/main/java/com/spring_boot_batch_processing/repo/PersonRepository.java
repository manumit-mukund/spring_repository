package com.spring_boot_batch_processing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_boot_batch_processing.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}