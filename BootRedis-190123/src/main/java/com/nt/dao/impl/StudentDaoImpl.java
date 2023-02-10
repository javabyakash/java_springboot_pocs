package com.nt.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.nt.dao.IStudentDao;
import com.nt.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private final String KEY = "STUDENT";
	
	@Resource(name="rt")
	private HashOperations<String, Integer, Student> opr;
	
	@Override
	public void addStudent(Student st) {
		opr.putIfAbsent(KEY, st.getStudId(), st);
	}

	@Override
	public void updateStudent(Student st) {
		opr.put(KEY, st.getStudId(), st);
	}

	@Override
	public Student getOneStudent(Integer id) {
		return opr.get(KEY, id);
	}

	@Override
	public Map<Integer, Student> getAllStudent() {
		return opr.entries(KEY);
	}

	@Override
	public void removeStudent(Integer id) {
		opr.delete(KEY, id);
	}

}
