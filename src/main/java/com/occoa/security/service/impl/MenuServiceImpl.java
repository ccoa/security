package com.occoa.security.service.impl;

import com.occoa.security.dao.MenuDao;
import com.occoa.security.model.Menu;
import com.occoa.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> findAll() {
		return (List<Menu>) menuDao.findAll();
	}

	@Override
	public Menu findById(Long id) {
		return menuDao.findById(id).orElse(null);
	}

}
