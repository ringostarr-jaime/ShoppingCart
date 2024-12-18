package com.shopping.cart.utilidades;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ErrorExceptionHandler {		
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {					
		StringBuilder buffer = new StringBuilder();		
		ex.getBindingResult().getAllErrors().forEach(error -> {			
			String errorMessage = error.getDefaultMessage();
			buffer.append(errorMessage+" - ");
		});					
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;	
		return new ResponseEntity<>(buffer, httpStatus);
	}
	
	public Logger logger = LoggerFactory.getLogger(ErrorExceptionHandler.class);
}
