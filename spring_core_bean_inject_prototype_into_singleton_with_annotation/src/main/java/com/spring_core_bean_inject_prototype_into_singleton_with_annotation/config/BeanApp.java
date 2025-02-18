package com.spring_core_bean_inject_prototype_into_singleton_with_annotation.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring_core_bean_inject_prototype_into_singleton_with_annotation.component.PrototypeBean;
import com.spring_core_bean_inject_prototype_into_singleton_with_annotation.component.SingletonBean;

@Configuration
public class BeanApp {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBean prototypeBean() {

		return new PrototypeBean();

	}

	@Bean
	public SingletonBean singletonBean() {

		return new SingletonBean();

	}
}
