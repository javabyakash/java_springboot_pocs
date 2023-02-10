package com.neosoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoft.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT COUNT(empEmail) FROM Employee WHERE empEmail=:empEmail")
	public Integer getEmailCountByEmail(String empEmail);
	
}
