package com.neosoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.entity.Employee;
import com.neosoft.repo.EmployeeRepository;
import com.neosoft.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public Integer saveEmployee(Employee emp) {
		return repo.save(emp).getEmpId();
	}

	public boolean isEmailIsExist(String empEmail) {
		Integer count = repo.getEmailCountByEmail(empEmail);
		return count > 0;
	}
	
	@Override
	public List<Employee> findAllEmps() {
		return repo.findAll();
	}
	
	@Override
	public Employee getOneEmp(Integer empId) {
		Optional<Employee> opt = repo.findById(empId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return new Employee();
	}
}
