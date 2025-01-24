package com.spring_boot_transaction_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_transaction_management.entity.Address;
import com.spring_boot_transaction_management.repo.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public Address addAddress(Address address) {

		Address addressSavedToDB = this.addressRepository.save(address);

		return addressSavedToDB;
	}

}
