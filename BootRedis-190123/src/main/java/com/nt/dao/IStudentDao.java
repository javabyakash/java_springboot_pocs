package com.nt.dao;

import java.util.Map;

import com.nt.model.Student;

public interface IStudentDao {
	void addStudent(Student st);
	void updateStudent(Student st);
	Student getOneStudent(Integer id);
	Map<Integer, Student> getAllStudent();
	void removeStudent(Integer id);
}
