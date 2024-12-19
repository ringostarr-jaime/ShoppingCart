package com.shopping.cart.utilidades;



import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ErrorExceptionHandler {		
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {					
		{ 
		Map<String, String> errors = new HashMap<>(); 
		ex.getBindingResult().getAllErrors().forEach(error -> { 
		String fieldName = ((FieldError) error).getField(); 
		String errorMessage = error.getDefaultMessage(); 
		errors.put(fieldName, errorMessage); 
		}); 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
	}
	
	public Logger logger = LoggerFactory.getLogger(ErrorExceptionHandler.class);
}
