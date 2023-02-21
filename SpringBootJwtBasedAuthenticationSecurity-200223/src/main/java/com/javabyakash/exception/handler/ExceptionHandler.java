package com.javabyakash.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javabyakash.exception.UserNotFoundException;
import com.javabyakash.model.ErrorType;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorType> userNotFoundExHandler(UserNotFoundException unfe){
		return new ResponseEntity<>(new ErrorType(unfe.getMessage(), "USERNAME IS NOT FOUND WITH GIVEN USERNAME", new Date().toString()),HttpStatus.NOT_FOUND);
	}
}
