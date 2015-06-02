package com.ray.controller.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
	
	private UserDao dao = new UserDao();

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException,DataAccessException {
		System.out.println("loginname is "+username);
		UserDetails user = null;
		
		try {
			Users users = dao.getDatabase(username);
			user = new User(users.getUsername(), users.getPassword()
					.toLowerCase(), true, true, true, true,
					getAuthorities(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	
	/**
	 * 获得访问角色权限
	 * 
	 * @param access
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// 所有的用户默认拥有ROLE_USER权限
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// 如果参数access为1.则拥有ROLE_ADMIN权限
		if (access.compareTo(1) == 0) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}

		return authList;
	}
	
}
