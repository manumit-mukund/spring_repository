package com.user_service_form_login_db_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.user_service_form_login_db_security.model.User;
import com.user_service_form_login_db_security.repo.UserRepository;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User();
		user1.setUserId(1311L);
		user1.setUsername("user1");
		user1.setPassword(bCryptPasswordEncoder.encode("user1"));
		user1.setRole("ROLE_USER");
		userRepository.save(user1);

		User admin1 = new User();
		admin1.setUserId(1312L);
		admin1.setUsername("admin1");
		admin1.setPassword(bCryptPasswordEncoder.encode("admin1"));
		admin1.setRole("ROLE_ADMIN");
		userRepository.save(admin1);

	}

}
