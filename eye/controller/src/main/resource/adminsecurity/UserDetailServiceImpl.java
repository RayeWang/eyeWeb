package com.ray.controller.adminsecurity;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ray.entity.Users;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("username is "+username);
		Users users = null;
		if(username.equals("admin")){
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("");
		
			
			users = new Users(username, "admin", authorities);
		}
		return users;
	}
}
