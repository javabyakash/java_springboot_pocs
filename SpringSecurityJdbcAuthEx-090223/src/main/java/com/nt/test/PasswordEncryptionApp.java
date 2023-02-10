package com.nt.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptionApp {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd1 = encoder.encode("RAM");
		String encodedPwd2 = encoder.encode("SYED");
		System.out.println(encodedPwd1);
		System.out.println(encodedPwd2);
	}
}
