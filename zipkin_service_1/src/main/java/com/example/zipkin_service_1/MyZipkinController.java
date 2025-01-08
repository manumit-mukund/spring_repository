package com.example.zipkin_service_1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/zipkin")
public class MyZipkinController {

	private static final Logger logger = LoggerFactory.getLogger(MyZipkinController.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/service_1")
	public String service_1() {

		logger.info("service_1() called...");
		
		return restTemplate.getForObject("http://localhost:8081/zipkin/service_2", String.class);

		//return "zipkin_service_1";
	}

	@RequestMapping("/service_2")
	public String service_2() {

		logger.info("service_2() called...");

		//return restTemplate.getForObject("http://localhost:8080/zipkin/service_1", String.class);

		return "zipkin_service_2";
	}

}
