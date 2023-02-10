package com.nt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;
import com.nt.repository.EmployeeRepo;
import com.nt.service.IEmployeeService;
import com.nt.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	@Cacheable(value = "employees",key = "#empId")
	public Employee getOneEmployee(Long empId) {
		return repo.findById(empId).orElseThrow(()-> new EmployeeNotFoundException(new StringBuilder().append("Employee ").append(empId).append(" Not Found!").toString()));
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	@CachePut(value = "employees",key = "#empId")
	public void updateEmployee(Long empId, Employee reqEmp) {
		Employee dbEmp = getOneEmployee(empId);
		repo.save(EmployeeUtil.setNonNullValues(reqEmp, dbEmp));
	}

	@Override
	@CacheEvict(value = "employees",key = "#empId")
	public void deleteEmployee(Long empId) {
		Employee dbEmployee = getOneEmployee(empId);
		repo.delete(dbEmployee);
	}
	
	
}
