package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService {
	Employee saveEmployee(Employee emp);
	Employee getOneEmployee(Long empId);
	List<Employee> getAllEmployee();
	void updateEmployee(Long empId,Employee emp);
	void deleteEmployee(Long empId);
}
