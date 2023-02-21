package com.javabyakash.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabyakash.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
	Optional<UserInfo> findByUname(String uname);
}
