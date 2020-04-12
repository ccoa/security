package com.occoa.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.occoa.security.model.Menu;
import com.occoa.security.service.MenuService;

@RestController
@RequestMapping(value = "/menus")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> listar() {
		List<Menu> menus = new ArrayList<>();
		
		try {
			menus = menuService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(menus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> obtenerPorId(@PathVariable("id") Long id) {
		Menu menu = null;
		
		try {
			menu = menuService.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(menu, HttpStatus.OK);
	}
}
