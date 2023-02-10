package com.neosoft.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.entity.UserInformation;

public interface UserInfoRepository extends JpaRepository<UserInformation, Integer> {
	Optional<UserInformation> findByUsername(String username);
}
