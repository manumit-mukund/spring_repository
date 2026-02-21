package com.spring_async_service_simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UserServiceSimpleApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserServiceSimpleApplication.class, args);

	}

}
