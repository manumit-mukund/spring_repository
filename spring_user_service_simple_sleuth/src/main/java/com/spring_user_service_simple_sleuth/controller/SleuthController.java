package com.spring_user_service_simple_sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleuthController {

    private static final Logger logger = LoggerFactory.getLogger(SleuthController.class);

    @GetMapping("/sleuth")
    public String helloSleuth() {
    	
        logger.info("Hello from Sleuth!");
        
        return "Sleuth Success!";
    }
}