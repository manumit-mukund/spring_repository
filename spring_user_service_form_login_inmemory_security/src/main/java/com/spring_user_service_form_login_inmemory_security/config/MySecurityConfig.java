package com.spring_user_service_form_login_inmemory_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.spring_user_service_form_login_inmemory_security.component.CustomAuthenticationSuccessHandler;
import com.spring_user_service_form_login_inmemory_security.exception.CustomAccessDeniedHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;
	
	@Autowired
    private CustomAuthenticationSuccessHandler customSuccessHandler;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
        http
        	.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(requests -> requests
                // Define access rules
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/", "/login", "/access-denied-error").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
            		.loginPage("/login")
            		.loginProcessingUrl("/doLogin")
            		.successHandler(customSuccessHandler)
					//.defaultSuccessUrl("/public/home")
            )
            .logout(logout -> logout
            		   .logoutSuccessUrl("/login") // Redirect to login page with a logout message
                       .invalidateHttpSession(true) // Invalidate HTTP session
                       .deleteCookies("JSESSIONID") // Delete cookies
                       .permitAll()
            )
            .exceptionHandling(exception -> exception
                // Register the custom access denied handler
                .accessDeniedHandler(customAccessDeniedHandler)
            );
        
        return http.build();
    }

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder(10);

	}

	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {

		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

		inMemoryUserDetailsManager.createUser(
				User
				.withUsername("user1")
				.password(bCryptPasswordEncoder.encode("user1"))
				.roles("USER")
				.build()
				);

		inMemoryUserDetailsManager
		.createUser(
				User.withUsername("admin1")
				.password(bCryptPasswordEncoder.encode("admin1"))
				.roles("USER", "ADMIN")
				.build());

		return inMemoryUserDetailsManager;
	}
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//		http.csrf(AbstractHttpConfigurer::disable)
//				.authorizeHttpRequests(
//						authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
//								.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//								.requestMatchers("/public/**", "/login/**").permitAll().anyRequest().authenticated())
//				.httpBasic(Customizer.withDefaults())
//				// .sessionManagement(httpSecuritySessionManagementConfigurer ->
//				// httpSecuritySessionManagementConfigurer
//				// .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				// if you uncomment the above two lines, the logged-in session will not be
//				// retained
//				// to access further admin pages like http://localhost:9001/admin/users/getall,
//				// etc.
//				.formLogin((form) -> form.loginPage("/login").loginProcessingUrl("/doLogin")
//						.defaultSuccessUrl("/public/home"));
//
//		return http.build();
//
//	}

}
