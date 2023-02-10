package com.neosoft.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neosoft.exception.EmployeeNotFoundException;
import com.neosoft.model.ErrorType;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorType> handleEmpNotFoundEx(EmployeeNotFoundException enfe){
		return new ResponseEntity<>(
					new ErrorType(enfe.getMessage(), new Date().toString(), "EMPLOYEE IS NOT FOUND WITH GIVEN ID!"),
					HttpStatus.NOT_FOUND);
	}
}
