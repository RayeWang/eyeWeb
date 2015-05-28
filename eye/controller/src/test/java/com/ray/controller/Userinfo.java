//package com.ray.controller;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//
//public class Userinfo extends User {
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	private String company;
//
//	public Userinfo(String username, String password,
//			Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//		// TODO Auto-generated constructor stub
//	}
//
//	public String getCompany() {
//		return company;
//	}
//
//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public Userinfo(String username, String password, boolean enabled,
//			boolean accountNonExpired, boolean credentialsNonExpired,
//			boolean accountNonLocked,
//			Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, enabled, accountNonExpired,
//				credentialsNonExpired, accountNonLocked, authorities);
//	}
//	
//	
//	public static Userinfo getUserinfo(){
//		
//		Userinfo userDetails = (Userinfo) SecurityContextHolder.getContext()
//			    .getAuthentication()
//			    .getPrincipal();
//		
//		return userDetails;
//		
//	}
//	
//	
//}
