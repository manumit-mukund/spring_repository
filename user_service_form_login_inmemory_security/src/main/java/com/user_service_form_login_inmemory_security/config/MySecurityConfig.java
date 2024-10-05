package com.user_service_form_login_inmemory_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(
				authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
					.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")								
					.requestMatchers("/public/**", "/login/**").permitAll()
					.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
					.requestMatchers("/admin/users/**").hasRole("ADMIN")								
					.anyRequest().authenticated())					
					.httpBasic(Customizer.withDefaults())								
					//.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
					//.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					//if you uncomment the above two lines, the logged-in session will not be retained 
					//to access further admin pages like http://localhost:9001/admin/users/getall, etc.
					.formLogin((form) -> form
							.loginPage("/login")
							.loginProcessingUrl("/doLogin")
					.defaultSuccessUrl("/public/home"));

		return http.build();

	}
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder(10);
		
	}

	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    
	    manager.createUser(User.withUsername("user1")
	        .password(bCryptPasswordEncoder.encode("user1"))
	        .roles("USER")
	        .build());
	    
	    manager.createUser(User.withUsername("admin1")
	        .password(bCryptPasswordEncoder.encode("admin1"))
	        .roles("USER", "ADMIN")
	        .build());
	    return manager;
	}

}