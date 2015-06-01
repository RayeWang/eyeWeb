package com.ray.controller.admin;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ray.entity.Users;
/**
 * 这里应该是登陆的处理的地方
 * @author Administrator
 *
 */
public class LoginDetail implements UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("loginname is "+username);
		Users user = null;
		if(username.equals("admin")){
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
			user = new Users(username, "admin",authorities);
		}
		return user;
	}

	

	
}
