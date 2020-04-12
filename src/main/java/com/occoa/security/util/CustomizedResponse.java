package com.occoa.security.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomizedResponse {
	
	public static ResponseEntity<Object> error(String message) {
		return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
