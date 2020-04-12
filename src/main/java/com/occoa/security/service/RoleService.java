package com.occoa.security.service;

import java.util.List;

import com.occoa.security.model.Role;

public interface RoleService {

	List<Role> findAll() throws Exception;
	
	Role register(Role role) throws Exception;
	
}
