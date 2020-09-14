package com.occoa.security.controller;

import com.occoa.security.model.User;
import com.occoa.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
@RestController
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping(value = "/")
	public Object list() {
		return userService.findAll();
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<Object> register(@RequestBody User user) {
		
		try {
			user = userService.register(user);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(user, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/")
	public ResponseEntity<Object> update(@RequestBody User user) {
		
		try {
			userService.update(user);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/")
	public ResponseEntity<Object> delete(@RequestBody String username) {
		
		try {
			userService.deleteByUsername(username);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/{username}/")
	public ResponseEntity<Object> findById(@PathVariable String username) {
		User user = null;
		
		try {
			user = userService.findByUsername(username);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{username}/password/")
	public ResponseEntity<Object> updatePassword(@PathVariable("username") String username, 
			@RequestBody String password) {
		
		try {
			userService.updatePasswordByUsername(password, username);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/{username}/")
	public ResponseEntity<Object> activate(@PathVariable("usuario") String username, 
			@RequestParam("activate") boolean activate) {
		
		try {
			userService.activate(username, activate);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
