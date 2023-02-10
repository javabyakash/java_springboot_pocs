package com.neosoft.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.entity.UserInformation;
import com.neosoft.repo.UserInfoRepository;
import com.neosoft.service.IUserInfoService;

@Service
public class UserInfoServiceImpl implements IUserInfoService, UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Integer saveUserInfo(UserInformation userInformation) {
		userInformation.setPassword(encoder.encode(userInformation.getUsername()));
		return userInfoRepo.save(userInformation).getId();
	}

	@Override
	public Optional<UserInformation> findByUsername(String username) {
		return userInfoRepo.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInformation> opt = findByUsername(username);
		if (opt.isEmpty())
			throw new UsernameNotFoundException("User Not Exist!!!");

		UserInformation userInfo = opt.get();

		return new User(username, userInfo.getPassword(), userInfo.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList()));
	}
}
