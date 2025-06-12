package com.user_service_simple_log_elastic_logstash_kibana.service;

import java.util.List;

import com.user_service_simple_log_elastic_logstash_kibana.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public User addUser(User user);

}
