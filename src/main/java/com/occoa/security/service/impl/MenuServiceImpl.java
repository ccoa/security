package com.occoa.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occoa.security.dao.MenuDao;
import com.occoa.security.model.Menu;
import com.occoa.security.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> findAll() throws Exception {
		
		return (List<Menu>) menuDao.findAll();
	}

	@Override
	public Menu findById(Long id) throws Exception {
		Optional<Menu> optionalMenu = menuDao.findById(id);
		
		if (optionalMenu.isPresent())
			return optionalMenu.get();
		
		return null;
	}

}
