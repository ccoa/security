package com.occoa.security.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.occoa.security.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long>{

}
