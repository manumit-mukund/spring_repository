package com.spring_boot_actuator.controller;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleRestController {
	
	@GetMapping("/hello")
	public String hello() {
		
		return "Hello User !! " + LocalDateTime.now();
		
	}
}
