package com.ray.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/**
 * 自定义的拦截器
 * @author Ray
 * @date 2015年5月29日12:55:19
 * @version 1.0
 */
public class MyFilter extends AbstractSecurityInterceptor  implements Filter{
	
	//与applicationContext-security.xml里的myFilter的属性securityMetadataSource对应，
	//其他的两个组件，已经在AbstractSecurityInterceptor定义
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		if (fi!=null) {
			invoke(fi);
		}
		
	}
	
	private void invoke(FilterInvocation fi) throws IOException, ServletException {
		// object为FilterInvocation对象
		//1.获取请求资源的权限
		//执行Collection<ConfigAttribute> attributes = SecurityMetadataSource.getAttributes(object);
		//2.是否拥有权限
		//获取安全主体，可以强制转换为UserDetails的实例
		//1) UserDetails
		// Authentication authenticated = authenticateIfRequired();
		//this.accessDecisionManager.decide(authenticated, object, attributes);
		//用户拥有的权限
		//2) GrantedAuthority
		//Collection<GrantedAuthority> authenticated.getAuthorities()
		System.out.println("用户发送请求！ ");
		InterceptorStatusToken token = null;
		if (fi!=null) {
			token = super.beforeInvocation(fi);
		}
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	public void destroy() {
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
