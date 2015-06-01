package com.ray.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import zy.bean.Resources;
import zy.bean.Roles;
import zy.bean.TAdmin;
import zy.system.business.TAdminBusiness;

@SuppressWarnings("deprecation")
@Service
public class MyUserDetailServiceImpl  implements UserDetailsService {
	@Autowired
	private TAdminBusiness tAdminBusiness;

	public TAdminBusiness gettAdminBusiness() {
		return tAdminBusiness;
	}

	public void settAdminBusiness(TAdminBusiness tAdminBusiness) {
		this.tAdminBusiness = tAdminBusiness;
	}

	//登录验证
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username is " + username);
		Userinfo userdetail = null;
		List<TAdmin> userList = this.tAdminBusiness.findByName(username);
		if (userList!=null&&userList.size()>0) {
			TAdmin users = userList.get(0);
			
			Collection<GrantedAuthority> grantedAuths = null;
			try {
				grantedAuths = obtionGrantedAuthorities(users);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			boolean enables = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			//封装成spring security的user
			userdetail = new Userinfo(users.getTAdminName().toString(), users.getTAdminCode(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
			
			userdetail.setCompany(users.getCompany());
		}
		return userdetail;
	}
	
	//取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(TAdmin user) throws Exception {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<Resources> resources = new ArrayList<Resources>();
		Set<Roles> roles = user.getRoles();
		
		for(Roles role : roles) {
			Set<Resources> tempRes = role.getResources();
			for(Resources res : tempRes) {
				resources.add(res);
			}
		}
		for(Resources res : resources) {
			authSet.add(new GrantedAuthorityImpl(res.getResourceName()));
		}
		return authSet;
	}
}
