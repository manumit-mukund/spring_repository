package com.spring_user_service_form_login_inmemory_security_6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests((authorize) -> {

			authorize.requestMatchers("api/v1/**").permitAll();
			authorize.anyRequest().authenticated();

		}).httpBasic(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails user1 = User
				.builder()
				.username("user1")
				.password(passwordEncoder().encode("user1"))
				.roles("USER")
				.build();

		UserDetails admin1 = User.builder()
				.username("admin1")
				.password(passwordEncoder().encode("admin1"))
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, admin1);
	}
}
