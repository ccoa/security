package com.occoa.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occoa.security.dao.RoleDao;
import com.occoa.security.model.Role;
import com.occoa.security.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findAll() throws Exception {
		
		return (List<Role>) roleDao.findAll();
	}

	@Override
	public Role register(Role role) throws Exception {
		
		return roleDao.save(role);
	}

}
