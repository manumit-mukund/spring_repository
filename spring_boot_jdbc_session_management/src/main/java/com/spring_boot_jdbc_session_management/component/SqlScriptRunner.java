package com.spring_boot_jdbc_session_management.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class SqlScriptRunner implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Override
	public void run(String... args) throws Exception {

		try (Connection connection = dataSource.getConnection()) {

			ClassPathResource resource = new ClassPathResource("db/schema/schema-mysql.sql");

			ScriptUtils.executeSqlScript(connection, resource);

		}
	}
}
