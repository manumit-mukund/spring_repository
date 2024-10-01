package com.user_service_form_login_db_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service_form_login_db_security.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
}
