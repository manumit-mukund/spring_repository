package com.spring_core_bean_scope_with_annotation.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {

	private String state;

	public SingletonBean() {

		this.state = "Initial State";

	}

	public void setState(String state) {

		this.state = state;

	}

	public String getState() {

		return state;

	}
}