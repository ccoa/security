package com.occoa.security.dao;

import org.springframework.data.repository.CrudRepository;

import com.occoa.security.model.Permission;

public interface PermissionDao extends CrudRepository<Permission, Long> {

}
