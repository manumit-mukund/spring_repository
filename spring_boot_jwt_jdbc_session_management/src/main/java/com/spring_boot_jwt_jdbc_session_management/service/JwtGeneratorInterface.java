package com.spring_boot_jwt_jdbc_session_management.service;

import java.util.Map;

import com.spring_boot_jwt_jdbc_session_management.entity.User;

public interface JwtGeneratorInterface {

	Map<String, String> generateToken(User user);

}