package com.neosoft.service;

import java.util.List;

import com.neosoft.entity.Employee;

public interface IEmployeeService {
	
	public Integer saveEmployee(Employee emp);
	public boolean isEmailIsExist(String empEmail);
	public List<Employee> findAllEmps();
	public Employee getOneEmp(Integer empId);
}
