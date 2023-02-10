package com.nt.dao;

import java.util.Map;

import com.nt.model.Employee;

public interface IEmployeeDao {
	void saveEmployee(Employee emp);
	void updateEmployee(Employee emp);
	Employee getOneEmployee(Integer id);
	Map<Integer, Employee> getAllEmployee(); 
	void removeEmployee(Integer id);
}
