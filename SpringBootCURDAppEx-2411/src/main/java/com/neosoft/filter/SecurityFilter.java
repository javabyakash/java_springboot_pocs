package com.neosoft.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.neosoft.util.JwtUtil;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// 1. read token from Auth head
		String token = request.getHeader("Authorization");

		if ((token != null)) {
			// do validation
			String username = jwtUtil.getUsername(token);

			// username should not be empty, conext-auth must be empty
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails user = userDetailsService.loadUserByUsername(username);

				// validate token
				boolean isValide = jwtUtil.validateTOken(token, user.getUsername());

				if (isValide) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,
							user.getPassword(), user.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					// final object stored in SecurityContext with User Details(un,pwd)
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}

			}
		}
		filterChain.doFilter(request, response);
	}

}
