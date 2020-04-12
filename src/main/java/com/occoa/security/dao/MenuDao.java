package com.occoa.security.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.occoa.security.model.Menu;

@Repository
public interface MenuDao extends CrudRepository<Menu, Long> {
	
	Optional<Menu> findById(Long id);

}
