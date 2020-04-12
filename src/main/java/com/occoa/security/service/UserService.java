package com.occoa.security.service;

import java.util.List;

import com.occoa.security.model.User;

public interface UserService {
	
	List<User> findAll() throws Exception;
	
	void update(User user) throws Exception;
	
	User register(User user) throws Exception;
	
	void deleteByUsername(String username) throws Exception;
	
	User findByUsername(String username) throws Exception;
	
	void updateStatusByUsername(String status, String username) throws Exception;

	void updatePasswordByUsername(String password, String username) throws Exception;

}
