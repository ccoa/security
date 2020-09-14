package com.occoa.security.service;

import com.occoa.security.model.User;

import java.util.List;

public interface UserService {
	
	List<User> findAll();
	
	void update(User user);
	
	User register(User user);
	
	void deleteByUsername(String username);
	
	User findByUsername(String username);

	void updatePasswordByUsername(String password, String username);
	
	void activate(String username, boolean activate);

}
