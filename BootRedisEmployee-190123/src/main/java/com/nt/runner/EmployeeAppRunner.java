package com.nt.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;

@Component
public class EmployeeAppRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		dao.saveEmployee(new Employee(201, "SAM", "DEV", 500.0));
		dao.saveEmployee(new Employee(202, "RAM", "QA", 600.0));
		dao.saveEmployee(new Employee(203, "ABHI", "BA", 700.0));
		
		Employee employee = dao.getOneEmployee(202);
		System.out.println(employee);
		System.out.println("-------------------");
		
		Map<Integer, Employee> allEmployee = dao.getAllEmployee();
		allEmployee.forEach((k,v) -> System.out.println(k+"-"+v));
		System.out.println("-------------------");
		
		dao.updateEmployee(new Employee(201, "SAMADHAN", "ARCH", 900.0));
		System.out.println(dao.getOneEmployee(201));
		System.out.println("-------------------");
		
		dao.removeEmployee(203);
		dao.getAllEmployee().forEach((k,v)->System.out.println(k+" - "+v));
	}

}
