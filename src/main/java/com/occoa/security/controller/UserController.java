package com.occoa.security.controller;

import com.occoa.security.model.User;
import com.occoa.security.service.UserService;
import com.occoa.security.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
@RestController
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<Object> list() {
		return Response.ok(userService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> register(@RequestBody User user) {
		return Response.created(userService.register(user));
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody User user) {
		userService.update(user);
		return Response.noContent();
	}
	
	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestBody String username) {
		userService.deleteByUsername(username);
		return Response.noContent();
	}
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<Object> findById(@PathVariable String username) {
		return Response.ok(userService.findByUsername(username));
	}
	
	@PutMapping(value = "/{username}/password")
	public ResponseEntity<Object> updatePassword(@PathVariable("username") String username, 
			@RequestBody String password) {
		userService.updatePasswordByUsername(password, username);
		return Response.noContent();
	}
	
	@PutMapping(value = "/{username}")
	public ResponseEntity<Object> activate(@PathVariable("usuario") String username, 
			@RequestParam("activate") boolean activate) {
		userService.activate(username, activate);
		return Response.noContent();
	}
}
