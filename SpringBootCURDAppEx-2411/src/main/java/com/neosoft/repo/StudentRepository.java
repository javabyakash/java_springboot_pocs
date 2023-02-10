package com.neosoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
