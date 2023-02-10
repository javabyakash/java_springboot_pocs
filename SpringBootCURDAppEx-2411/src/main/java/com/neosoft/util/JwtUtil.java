package com.neosoft.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	//Read secret value from application.properties
	@Value("${app.secret}")
	private String secreteKey;
	
	// 6. validate user-name in token and database, and check isExpDate
	public boolean validateTOken(String token, String username) {
		String tokenUsername = getUsername(token);
		return (username.equals(tokenUsername) && !isTokenExpire(token));
	}
	
	// 5. validate Expiry Date
	public boolean isTokenExpire(String token) {
		Date expiryDate = getExpiryDate(token);
		return expiryDate.before(new Date(System.currentTimeMillis()));
	}
	
	// 4. Read Subject/User
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	// 3. Get Claims
	public Date getExpiryDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	// 2. Read Claims
	public Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secreteKey.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
	
	// 1. Generate Token
	public String generateToken(String subject) {
		return Jwts.builder()
		.setSubject(subject)
		.setIssuer("AKASH")
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15)))
		.signWith(SignatureAlgorithm.HS512, secreteKey.getBytes())
		.compact();
	}
}
