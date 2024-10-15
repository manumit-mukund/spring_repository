package com.spring_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class UserServiceAspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceAspectApplication.class, args);
	}

}
