package com.spring_core_bean_scope_with_annotation_web.component;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
//@Scope("application") //This will also work fine
@ApplicationScope
public class ApplicationScopedBean {

	private String appData;

	public ApplicationScopedBean() {

		appData = "Application-Wide Data" + new Date();

	}

	public String getAppData() {

		return appData;

	}
}
