package com.javabyakash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabyakash.exception.UserNotFoundException;
import com.javabyakash.model.UserInfo;
import com.javabyakash.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody UserInfo userInfo) {
		Integer userId = service.saveUser(userInfo);
		return new ResponseEntity<>(
				new StringBuilder().append("USER ").append(userId).append(" SAVED SUCCUSSFULLY!").toString(),
				HttpStatus.CREATED);
	}

	@GetMapping("/get/uname/{username}")
	public ResponseEntity<UserInfo> getUserByUname(@PathVariable("username") String username) {
		UserInfo userByUname = null;
		try {
			userByUname = service.getUserByUname(username);
		} catch (UserNotFoundException unfe) {
			unfe.printStackTrace();
			throw unfe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(userByUname);
	}
}