package com.spring_boot_sleuth_zipkin_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/zipkin")
public class MyZipkinController {

	private static final Logger logger = LoggerFactory.getLogger(MyZipkinController.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/service_1")
	public String service_1() {

		logger.info("service_1() called...");

		return restTemplate.getForObject("http://localhost:9001/zipkin/service_2", String.class);

	}

	@RequestMapping("/service_2")
	public String service_2() {

		logger.info("service_2() called...");

		return "zipkin_service_2";
	}

}
