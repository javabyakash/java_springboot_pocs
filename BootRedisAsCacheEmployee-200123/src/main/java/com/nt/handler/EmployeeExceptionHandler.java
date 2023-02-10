package com.nt.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.ErrorType;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorType> employeeNotFound(EmployeeNotFoundException enfe){
		return new ResponseEntity<>(
				new ErrorType(enfe.getMessage(), new Date().toString(), 
				"EMPLOYEE NOT FOUND"),
				HttpStatus.NOT_FOUND);
	}
}
