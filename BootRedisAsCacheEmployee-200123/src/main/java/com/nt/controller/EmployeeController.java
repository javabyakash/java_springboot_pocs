package com.nt.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<>(service.saveEmployee(emp), HttpStatus.CREATED);
	}

	@GetMapping("/get/one/{empId}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable Long empId) {
		ResponseEntity<Employee> resp = null;
		try {
			resp = new ResponseEntity<>(service.getOneEmployee(empId), HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			throw enfe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllEmployees() {
		return ResponseEntity.ok(service.getAllEmployee());
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<?> updateEmployee(@PathVariable Long empId, @RequestBody Employee emp) {
		ResponseEntity<String> resp = null;
		try {
			service.updateEmployee(empId, emp);
			resp = new ResponseEntity<>("Employee Updated Successfully!", HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			throw enfe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long empId) {
		ResponseEntity<String> resp = null;
		try {
			service.deleteEmployee(empId);
			resp = new ResponseEntity<>("Employee '" + empId + "' Deleted!", HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			throw enfe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
}
