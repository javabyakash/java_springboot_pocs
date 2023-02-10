package com.neosoft.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neosoft.entity.ErrorType;
import com.neosoft.exception.StudentNotFoundException;

@RestControllerAdvice
public class StudentExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorType> handleStudentNotFoundExcpetion(StudentNotFoundException snfe){
		return new ResponseEntity<>(new ErrorType(
				snfe.getMessage(), 
				new Date().toString(), 
				"STUDENT IS NOT FOUND WITH GIVEN ID"),
				HttpStatus.NOT_FOUND);
	}
}
