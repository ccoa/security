package com.occoa.security.service;

import java.util.List;

import com.occoa.security.model.Menu;

public interface MenuService {
	
	List<Menu> findAll() throws Exception;
	
	Menu findById(Long id) throws Exception;

}
