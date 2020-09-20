package com.occoa.security.service;

import java.util.List;

import com.occoa.security.model.Role;

public interface RoleService {

	List<Role> findAll();
	
	Role register(Role role);
	
}
