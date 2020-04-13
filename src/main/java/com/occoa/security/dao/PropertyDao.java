package com.occoa.security.dao;

import org.springframework.data.repository.CrudRepository;

import com.occoa.security.model.Property;

public interface PropertyDao extends CrudRepository<Property, Long> {

}
