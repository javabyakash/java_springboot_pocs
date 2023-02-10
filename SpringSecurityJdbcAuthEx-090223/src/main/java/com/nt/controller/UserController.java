package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/hello")
	public String showHello(Model map) {
		LocalDateTime time = LocalDateTime.now();
		int hour = time.getHour();
		if(hour<12)
			map.addAttribute("message", new StringBuilder().append("Good Morning User"));
		else if(hour<16)
			map.addAttribute("message", new StringBuilder().append("Good Afternoon User"));
		else if(hour<18)
			map.addAttribute("message", new StringBuilder().append("Good Evening User"));
		else
			map.addAttribute("message", new StringBuilder().append("Good Night User"));
		return "hello";
	}
	
	@GetMapping("/admin")
	public String showAdmin() {
		return "admin";
	}
	
	@GetMapping("/customer")
	public String showCustomer() {
		return "customer";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
}
