package com.neosoft.service;

import java.util.List;

import com.neosoft.entity.Student;

public interface IStudentService {
	Integer saveStudent(Student student);
	Student getOneStudent(Integer id);
	List<Student> getAllStudent();
	void removeStudent(Integer id);
	void updateStudent(Student student);
	boolean isStudentExist(Integer id);
}
