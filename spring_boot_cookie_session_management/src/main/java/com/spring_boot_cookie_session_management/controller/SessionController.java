package com.spring_boot_cookie_session_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/cookie")
public class SessionController {

	@GetMapping("/create")
	public String createSession(HttpServletResponse response) {

		Cookie sessionCookie1 = new Cookie("sessionId1", "123456");
		Cookie sessionCookie2 = new Cookie("sessionId2", "1234566");
		Cookie sessionCookie3 = new Cookie("sessionId3", "12345666");

		// Set cookie's max age to 1 minute (60 seconds)
		sessionCookie1.setMaxAge(60);
		response.addCookie(sessionCookie1);
		response.addCookie(sessionCookie2);
		response.addCookie(sessionCookie3);

		String output = """
				<html>
				    <body>
				        <p>Cookie sessionId added to the response.</p>
				    </body>
				</html>
				     """;

		return output;

		// Test url: http://localhost:9001/cookie/create

	}

	@GetMapping("/get")
	public String getSession(HttpServletRequest request) {

		String output = "No cookies found";

		Cookie[] cookies = request.getCookies();

		List<String> cookieList = new ArrayList<>();

		if (cookies != null) {

			for (Cookie cookie : cookies) {

				cookieList.add(cookie.getValue());
			}

			output = """
					<html>
					    <body>
					        <h3>cookies = </h3>
					    </body>
					</html>
					     """;

			output += cookieList.toString();
		}

		return output;

		// Test url: http://localhost:9001/cookie/get

	}

	@GetMapping("/invalidate")
	public String invalidateSession(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (Cookie cookie : cookies) {

				// cookie.setValue(null); // Clear the cookie value. This is optional
				cookie.setMaxAge(0); // Set Max-Age to 0 for immediate deletion
				response.addCookie(cookie);

			}

			return "cookie Invalidated";

		} else {

			return "No cookies found to invalidate";

		}

		// Test url: http://localhost:9001/cookie/invalidate

	}
}
