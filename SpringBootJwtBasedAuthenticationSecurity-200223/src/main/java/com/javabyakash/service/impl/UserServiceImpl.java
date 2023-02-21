package com.javabyakash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabyakash.exception.UserNotFoundException;
import com.javabyakash.model.UserInfo;
import com.javabyakash.repo.UserRepository;
import com.javabyakash.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;
	
	public Integer saveUser(UserInfo userInfo) {
		UserInfo savedUser = repo.save(userInfo);
		return savedUser.getUid();
	}

	@Override
	public UserInfo getUserByUname(String uname) {
		return repo.findByUname(uname).orElseThrow(()->new UserNotFoundException(uname + " NOT FOUND EXCEPTION!"));
	}

}
