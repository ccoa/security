package com.occoa.security.controller;

import com.occoa.security.model.Role;
import com.occoa.security.service.RoleService;
import com.occoa.security.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {

	private final RoleService roleService;
	
	@GetMapping
	public ResponseEntity<Object> list() {
		return Response.ok(roleService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> register(@RequestBody Role role) {
		return Response.created(roleService.register(role));
	}

}
