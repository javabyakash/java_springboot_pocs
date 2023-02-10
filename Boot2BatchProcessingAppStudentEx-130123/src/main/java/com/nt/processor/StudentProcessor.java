package com.nt.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.nt.model.Student;

public class StudentProcessor implements ItemProcessor<Student, Student> {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Student process(Student item) throws Exception {
		log.info("FROM PROCESS METHOD");
		var totalOfMarks = item.getMark1() + item.getMark2() + item.getMark3();
		var percentage = totalOfMarks / 3.0;
		item.setPercentage(percentage);
		if (percentage >= 80)
			item.setGrade("A");
		else if (percentage >= 60)
			item.setGrade("B");
		else if (percentage >= 50)
			item.setGrade("C");
		else
			item.setGrade("D");
		log.info("ABOUT TO EXIT FROM PROCESS METHOD {}",item);
		return item;
	}

}
