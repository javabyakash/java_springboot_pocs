package com.nt.runner;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.dao.IStudentDao;
import com.nt.model.Student;

@Component
public class StudentAppRunner implements CommandLineRunner {
	
	@Autowired
	private IStudentDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		dao.addStudent(new Student(101,"Akash",500.0));
		dao.addStudent(new Student(102,"Mahesh",600.0));
		dao.addStudent(Student.builder().studId(103).studName("Karan").studFee(700.0).build());
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		Map<Integer, Student> allStudent = dao.getAllStudent();
		allStudent.forEach((k,v)->System.out.println(k+"-"+v));

		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		Student student = dao.getOneStudent(101);
		System.out.println(student);
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		dao.removeStudent(102);
		dao.getAllStudent().forEach((k,v)->System.out.println(k+"-"+v));
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");

		dao.updateStudent(Student.builder().studId(101).studName("Prakash").studFee(550.0).build());
		allStudent.forEach((k,v)->System.out.println(k+"-"+v));
	}

}
