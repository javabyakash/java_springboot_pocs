package com.javabyakash.service;

import com.javabyakash.model.UserInfo;

public interface IUserService {
	Integer saveUser(UserInfo userInfo);
	UserInfo getUserByUname(String uname);
}
