package com.occoa.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.occoa.security.model.User;
import com.occoa.security.service.UserService;

@RequestMapping(value = "/users")
@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public ResponseEntity<Object> list() {
		List<User> users = new ArrayList<User>();
		
		try {
			users = userService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(users, HttpStatus.OK);
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
	public ResponseEntity<Object> findById(@PathVariable("username") String username) {
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
