package com.occoa.security.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occoa.security.model.Role;
import com.occoa.security.service.RoleService;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {

	private final RoleService roleService;
	
	@GetMapping
	public ResponseEntity<Object> listar() {
		List<Role> roles = new ArrayList<>();
		
		try {
			roles = roleService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(roles, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> register(@RequestBody Role role) throws Exception {
		return new ResponseEntity<Object>(roleService.register(role), HttpStatus.CREATED);
	}

}
