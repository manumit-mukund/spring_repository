package com.spring_core_autowire_interface_with_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring_core_autowire_interface_with_annotation.model.Circle;

@Configuration
@ComponentScan
public class BeanConfig {

 /* @Bean
  Square square() {
  
    return new Square();
    
  }*/

  @Bean
  Circle circle() {
	  
    return new Circle();
    
  }
}
