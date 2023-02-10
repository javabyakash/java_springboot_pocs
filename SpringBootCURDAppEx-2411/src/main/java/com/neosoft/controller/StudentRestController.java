package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.Student;
import com.neosoft.exception.StudentNotFoundException;
import com.neosoft.service.IStudentService;
import com.neosoft.util.StudentUtil;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	@Autowired
	private IStudentService service;

	// 1. SAVE OPERATION
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student stud) {
		ResponseEntity<String> resp = null;
		try {
			Integer studentId = service.saveStudent(stud);
			resp = ResponseEntity.ok(new StringBuffer().append("STUDENT '").append(studentId)
					.append("' SAVED SUCCESSFULLY!").toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("SOMETHING WENT WRONG, CONTACT WITH ADMIN!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	// 2. GET ONE OPERATION
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOneStudent(@PathVariable("id") Integer studId) {
		ResponseEntity<?> resp = null;
		try {
			Student oneStudent = service.getOneStudent(studId);
			resp = ResponseEntity.ok(oneStudent);
		} catch (StudentNotFoundException snfe) {
			throw snfe;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("SOMETHING WENT WRONG, CONTACT WITH ADMIN!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//3. GET ALL OPERATION
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudent() {

		ResponseEntity<?> resp = null;
		try {
			resp = ResponseEntity.ok(service.getAllStudent());
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("SOMETHING WENT WRONG, CONTACT WITH ADMIN!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer studId) {
		ResponseEntity<String> resp = null;
		try {
			service.removeStudent(studId);
			resp = ResponseEntity.ok("STUDENT DELETED SUCCESSFULLY!");
		} catch (StudentNotFoundException snfe) {
			throw snfe;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("SOMETHING WENT WRONG, CONTACT WITH ADMIN!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//4. UPDATE OPERATION
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable("id") Integer id, @RequestBody Student reqStudent) {
		ResponseEntity<String> resp = null;
		try {
			if (service.isStudentExist(id)) {
				Student dbStudent = service.getOneStudent(id);
				StudentUtil.copyNonNullValues(dbStudent, reqStudent);
				service.updateStudent(dbStudent);
				resp = ResponseEntity.ok("STUDENT UPDATED SUCCESSFULLY!");
			} else
				throw new StudentNotFoundException(
						new StringBuffer()
						.append("STUDENT '")
						.append(id)
						.append("' NOT EXIST!")
						.toString()
						);
		} catch (StudentNotFoundException snfe) {
			throw snfe;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("SOMETHING WENT WRONG, CONTACT WITH ADMIN!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
