package com.ray.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class UserPassAuthentication extends
		UsernamePasswordAuthenticationFilter {
	
	public UserPassAuthentication(){
		super();
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(
				"/login.ad","POST"));
	}

	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		String name = obtainUsername(request);
		String pass = obtainPassword(request);

		System.out.println("Loginname is "+name);
		
		if(!name.equals("admin") || !pass.equals("admin")){
			throw new AuthenticationServiceException("用户名活密码错误"); 
		}
		if(!request.getMethod().equals("POST")){
			throw new AuthenticationServiceException("没有权限登陆 " );
		}
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(name, pass);
		// Place the last username attempted into HttpSession for views
		
		// 允许子类设置详细属性
        setDetails(request, authRequest);
		
        
        // 运行UserDetailsService的loadUserByUsername 再次封装Authentication
		return this.getAuthenticationManager().authenticate(authRequest);
	}

}
