package com.spring_core_autowire_abstract_class_with_annotation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring_core_autowire_abstract_class_without_annotation.App;

@SpringBootTest(classes = App.class)

class AppTests {

	@Test
	void contextLoads() {
	}

}
