package com.nt.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private final String KEY = "Employee";
	
	@Resource(name = "rt")
	private HashOperations<String, Integer, Employee> opr;
	
	@Override
	public void saveEmployee(Employee emp) {
		opr.putIfAbsent(KEY, emp.getEmpId(), emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		opr.put(KEY, emp.getEmpId(), emp);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Employee employee = opr.get(KEY, id);
		return employee;
	}

	@Override
	public Map<Integer, Employee> getAllEmployee() {
		Map<Integer, Employee> map = opr.entries(KEY);
		return map;
	}

	@Override
	public void removeEmployee(Integer id) {
		opr.delete(KEY, id);
	}

}
