package com.neosoft.service;

import java.util.Optional;

import com.neosoft.entity.UserInformation;

public interface IUserInfoService {
	Integer saveUserInfo(UserInformation userInformation);
	Optional<UserInformation> findByUsername(String username);
}
