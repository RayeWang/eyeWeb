package com.ray.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetail implements UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Collection< GrantedAuthority >  auths = new  ArrayList < GrantedAuthority > ();
        
        auths.add(new GrantedAuthorityImpl("ROLE_USER"));
        if (username.equals("admin")) {
            auths = new  ArrayList < GrantedAuthority > ();
            GrantedAuthorityImpl auth1 = new  GrantedAuthorityImpl("ROLE_ADMIN");
            auths.add(auth1);
        } 
        
//         User(String username, String password, boolean enabled, boolean accountNonExpired,
//                     boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) { 
        User user  =   new  User(username,
                 " user" ,  true ,  true ,  true ,  true , auths);
         return  user;
	}

	private class GrantedAuthorityImpl implements GrantedAuthority{
		
		private String role;

		public GrantedAuthorityImpl(String role){
			this.role = role;
		}
		public String getAuthority() {
			return null;
		}
		
	}
}
