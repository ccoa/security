package com.occoa.security.controller;

import com.occoa.security.service.MenuService;
import com.occoa.security.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/menus")
@AllArgsConstructor
public class MenuController {

	private final MenuService menuService;
	
	@GetMapping
	public ResponseEntity<Object> list() {
		return Response.ok(menuService.findAll());
	}
	
	@GetMapping
	public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
		return Response.ok(menuService.findById(id));
	}
}
