package com.ray.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ray.entity.Users;
/**
 * 这里应该是登陆的处理的地方
 * @author Administrator
 *
 */
public class LoginDetail implements UserDetailsService,AuthenticationManager {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("loginname is "+username);
		Users user = null;
		if(username.equals("admin")){
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
			user = new Users(username, "admin", authorities);
		}
		return user;
	}

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		System.out.println("authenticate is runing");
		return null;
	}

	
}
