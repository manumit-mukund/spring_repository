package com.spring_core_bean_scope_with_annotation_web.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class ApplicationScopedBean {

	private String appData = "Application-Wide Data";

	public String getAppData() {

		return appData;

	}
}
