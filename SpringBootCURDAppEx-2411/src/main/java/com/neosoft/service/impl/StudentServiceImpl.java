package com.neosoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.entity.Student;
import com.neosoft.exception.StudentNotFoundException;
import com.neosoft.repo.StudentRepository;
import com.neosoft.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Integer saveStudent(Student student) {
		return repo.save(student).getStudId();
	}

	@Override
	public Student getOneStudent(Integer id) {

		/*
		//USING IF ELSE CODE:
		
		Optional<Student> opt = repo.findById(id);
		
		if(opt.isPresent())
			return opt.get();
		else
			throw new StudentNotFoundException(
						new StringBuffer()
						.append("STUDENT '")
						.append(id)
						.append("' NOT FOUND!")
						.toString()
						);
		*/
		
		//USING orElse() of Optional class.
		return repo.findById(id).orElseThrow(()->new StudentNotFoundException(
						new StringBuffer()
						.append("STUDENT '")
						.append(id)
						.append("' NOT FOUND!")
						.toString()
						));
		
	}

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public void removeStudent(Integer id) {
		Student student = getOneStudent(id);
		repo.delete(student);
	}

	@Override
	public void updateStudent(Student student) {
		repo.save(student);
	}
	
	@Override
	public boolean isStudentExist(Integer id) {
		return repo.existsById(id);
	}

}
