package com.spring_boot_async_service_multiple.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3); // Match pool size to your 3 parallel tasks
		executor.setMaxPoolSize(5);
		executor.setThreadNamePrefix("AsyncThread-");
		executor.initialize();

		return executor;
	}
}