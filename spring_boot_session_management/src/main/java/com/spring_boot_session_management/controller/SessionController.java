package com.spring_boot_session_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionController {

	@GetMapping("/create")
	public String createSession(HttpSession session) {

		String sessionId = "";
		String username1 = "";
		String username2 = "";
		String username3 = "";

		if (session.isNew()) {

			sessionId = "New session created: " + session.getId();

			session.setAttribute("username1", "manu1");
			session.setAttribute("username2", "manu2");
			session.setAttribute("username3", "manu3");

			username1 = (String) session.getAttribute("username1");
			username2 = (String) session.getAttribute("username2");
			username3 = (String) session.getAttribute("username3");

		} else {

			sessionId = "Existing session accessed: " + session.getId();

			username1 = (String) session.getAttribute("username1");
			username2 = (String) session.getAttribute("username2");
			username3 = (String) session.getAttribute("username3");

		}

		String output = """
				<html>
				    <body>
				        <p>username attribute added to the session</p>
				        """;

		output += "<p>sessionId = " + sessionId + "</p>";

		output += "<p>username1 = " + username1 + "</p>";
		output += "<p>username2 = " + username2 + "</p>";
		output += "<p>username3 = " + username3 + "</p>";

		output += "</body></html>";

		return output;

		// Test url: http://localhost:9001/session/create

	}

	@GetMapping("/get")
	public String getSession(HttpServletRequest request) {

		// Attempt to retrieve existing session without creating a new one
		HttpSession session = request.getSession(false);

		String sessionId = "sessionId not found";
		String username1 = "username1 not found";
		String username2 = "username2 not found";
		String username3 = "username3 not found";

		if (session != null) {

			sessionId = "session accessed: " + session.getId();

			// Retrieve the username attribute from the session
			username1 = (String) session.getAttribute("username1");
			username2 = (String) session.getAttribute("username2");
			username3 = (String) session.getAttribute("username3");
		}

		String output = """
				<html>
				    <body>
				        <p>username attribute accessed from the session</p>
				        """;

		output += "<p>sessionId = " + sessionId + "</p>";

		output += "<p>username1 = " + username1 + "</p>";
		output += "<p>username2 = " + username2 + "</p>";
		output += "<p>username3 = " + username3 + "</p>";
		output += "</body></html>";

		return output;

		// Test url: http://localhost:9001/session/get

	}

	@GetMapping("/invalidate")
	public String invalidateSession(HttpServletRequest request) {

		HttpSession session = request.getSession(false); // Use false to avoid creating a new session if it doesn't
		// exist);



		String output = "session not found";

		if (session != null) {

			// Invalidate the session
			session.invalidate();

			output = """
					<html>
						<body>
							<p>The session has been invalidated.</p>
						</body>
					</html>
					""";
		}

		return output;

		// Test url: http://localhost:9001/session/invalidate

	}
}
