package com.neosoft.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.constant.EmployeeConstant;
import com.neosoft.exception.EmployeeNotFoundException;
import com.neosoft.model.Employee;

@RestController
public class EmployeeRestController {
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<>(
				new StringBuffer()
				.append("EMPLOYEE SAVED SUCCESSFULLY! :")
				.append(emp)
				.toString(),
				HttpStatus.CREATED
				);
	}
	
	@GetMapping("/one/employee/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable("id") Integer id){
		if(id!=101) {
			throw new EmployeeNotFoundException(
					new StringBuffer()
					.append(EmployeeConstant.EMP)
					.append(id)
					.append(EmployeeConstant.NOT_EXIST)
					.toString());
		}
		else 
			return ResponseEntity.ok(new Employee(101, "AKASH", "SOFTWARE ENGINEER", 1000.0));
	}
	
	@GetMapping("/all/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(List.of(
				new Employee(101, "AKASH", "SOFTWARE ENGINEER", 1000.0),
				new Employee(102, "SMITH", "HR", 2000.0),
				new Employee(103, "JOHN", "BA", 3000.0),
				new Employee(104, "SCOTT", "DBA", 4000.0)
				),
				HttpStatus.OK
				);
	}
	
	@DeleteMapping("/delete/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id){
		if(id!=101) {
			throw new EmployeeNotFoundException(
					new StringBuffer()
					.append(EmployeeConstant.EMP)
					.append(id)
					.append(EmployeeConstant.NOT_EXIST)
					.toString());
		}
		else {
			return ResponseEntity.ok(
					new StringBuffer()
					.append("EMPLOYEE '")
					.append(id)
					.append("'DELETED SUCCESSFULLY!")
					.toString()
					);
		}
	}
	
	@PutMapping("/update/employee/{id}")
	public ResponseEntity<String> updateEmployee(
			@PathVariable("id") Integer empId			)
	{
		if(empId!=101) {
			throw new EmployeeNotFoundException(
					new StringBuffer()
					.append(EmployeeConstant.EMP)
					.append(empId)
					.append(EmployeeConstant.NOT_EXIST)
					.toString());
		}
		else
			return ResponseEntity.ok("EMPLOYEE UPDATED SUCCESSFULLY!");
	}
	
	@RequestMapping(value = "/hiring", method = RequestMethod.HEAD)
	public ResponseEntity<String> employeeHiring(){
		return ResponseEntity.ok("");
	}
	
	@RequestMapping(value = "/attendence", method = RequestMethod.OPTIONS)
	public ResponseEntity<String> employeeAttendence(){
		return new ResponseEntity<>("IN EMPLOYEE ATTENDENCE",HttpStatus.OK);
	}
}