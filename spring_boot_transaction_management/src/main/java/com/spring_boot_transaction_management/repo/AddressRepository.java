package com.spring_boot_transaction_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot_transaction_management.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}

