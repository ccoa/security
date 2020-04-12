package com.occoa.security.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.occoa.security.model.Error;

@Repository
public interface ErrorDao extends CrudRepository<Error, Long> {

}
