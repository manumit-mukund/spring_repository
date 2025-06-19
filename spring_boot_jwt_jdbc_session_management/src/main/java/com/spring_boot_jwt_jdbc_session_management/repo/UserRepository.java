package com.spring_boot_jwt_jdbc_session_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_boot_jwt_jdbc_session_management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserNameAndPassword(String userName, String password);

}
