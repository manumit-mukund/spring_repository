package com.spring_boot_jwt_jdbc_session_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jwt_jdbc_session_management.entity.User;
import com.spring_boot_jwt_jdbc_session_management.exception.UserNotFoundException;
import com.spring_boot_jwt_jdbc_session_management.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
  private UserRepository userRepository;
  
  @Autowired
  public UserServiceImpl(UserRepository userRepository){
    this.userRepository=userRepository;
  }
  
  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }
  
  @Override
  public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
    User user = userRepository.findByUserNameAndPassword(name, password);
    if(user == null){
       throw new UserNotFoundException("Invalid id and password");
    }
    return user;
  }
}