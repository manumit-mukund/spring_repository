package com.spring_user_service_simple_sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@CrossOrigin
//@EnableZipkinServer

public class SleuthApplication {

	private static final Logger logger = LoggerFactory.getLogger(SleuthApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
	}

	@GetMapping("/hello")
	public String helloSleuth() {

		logger.info("Hello from Sleuth!");

		return "Hello Sleuth!";

	}

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();

	}

}