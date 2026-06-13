package com.user_service_calling_contact_with_eureka_circuitbreaker_feignclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user_service_calling_contact_with_eureka_circuitbreaker_feignclient.model.Contact;

//Name matches ContactService application name, url is optional if using Eureka
@FeignClient(name = "contact-service-with-eureka-feignclient")
public interface FeignClientContact {

	@GetMapping("/contact/user/{userId}")
	List<Contact> getContactsOfUser(@PathVariable("userId") Long userId);

	@GetMapping("/contact/getall")
	List<Contact> getAllContacts();

}
