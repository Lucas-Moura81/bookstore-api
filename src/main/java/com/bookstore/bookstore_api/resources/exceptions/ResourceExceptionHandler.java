package com.bookstore.bookstore_api.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookstore.bookstore_api.service.exception.ObjectNotFoundException;

import jakarta.servlet.ServletRequest;

public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		 StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); 
	}

}