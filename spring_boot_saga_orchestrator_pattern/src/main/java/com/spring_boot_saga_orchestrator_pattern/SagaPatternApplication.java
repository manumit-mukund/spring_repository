package com.spring_boot_saga_orchestrator_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SagaPatternApplication {

	public static void main(String[] args) {

		SpringApplication.run(SagaPatternApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();

	}

}
