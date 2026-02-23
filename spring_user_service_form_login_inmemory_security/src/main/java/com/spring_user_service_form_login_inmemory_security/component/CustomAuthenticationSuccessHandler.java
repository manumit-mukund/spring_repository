package com.spring_user_service_form_login_inmemory_security.component;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String targetUrl = "/login"; // Default URL

		for (GrantedAuthority grantedAuthority : authorities) {

			if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {

				targetUrl = "/admin-dashboard"; // Admin specific URL
				break;

			} else if (grantedAuthority.getAuthority().equals("ROLE_USER")) {

				targetUrl = "/user-dashboard"; // User specific URL
				break;

			} else if (grantedAuthority.getAuthority().equals("ROLE_GUEST")) {

				targetUrl = "/guest-dashboard"; // Guest specific URL
				break;

			}
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
}
