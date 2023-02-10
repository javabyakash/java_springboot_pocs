package com.neosoft.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neosoft.entity.Employee;
import com.neosoft.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeRestController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IEmployeeService service;

	@GetMapping("/")
	public String showEmpReg() {
		log.info("FROM SHOW-EMP-REG METHOD");
		return "EmployeeReg";
	}

	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute(name = "employee") Employee employee, Model map) {
		log.info("FROM REGISTER-EMP METHOD");
		Integer empId = service.saveEmployee(employee);
		map.addAttribute("message",
				new StringBuilder().append("EMPLOYEE '").append(empId).append("' ADDED SUCCUSSFULLY!"));
		log.info("ABOUT TO EXIT FROM REGISTER-EMP METHOD");
		return "EmployeeReg";
	}

	@GetMapping("/checkEmail")
	public @ResponseBody String isEmailIdExist(@RequestParam String empEmail) {
		log.info("FROM IS-EMAIL-ID-EXIT METHOD");
		String message = "";
		System.out.println("Ajax method executed!");
		if (service.isEmailIsExist(empEmail)) {
			message = empEmail + " Already exist";
		}
		log.info("ABOUT TO EXIST FROM IS-EMAIL-ID-EXIT METHOD");
		return message;
	}
	
	@GetMapping("/all")
	public String getAllEmps(Model map) {
		List<Employee> allEmps = service.findAllEmps();
		map.addAttribute("listEmps",allEmps);
		return "view_all";
	}
	
	@GetMapping("/one")
	public String showOneEmp() {
		return "view_one";
	}
	
	@GetMapping("/getOne")
	public String getOneEmp(@RequestParam Integer empId,Model map) {
		log.info("FROM GET-ONE METHOD");
		Employee oneEmp = service.getOneEmp(empId);
		if(!ObjectUtils.isEmpty(oneEmp)) {
			map.addAttribute("oneEmp",oneEmp);
		}
		else {
			map.addAttribute("respText",new StringBuilder().append("EMPLOYEE ID ").append(empId).append(" NOT FOUND!"));
		}
		return "view_one";
	}

}
