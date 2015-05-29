package com.ray.controller.admin;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 用来判断用户是否有访问资源的权限的拦截器
 * @author Ray
 * @date 2015年5月29日16:13:34
 * @version 1.0
 */
public class AccessDecision implements AccessDecisionManager{

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		System.out.println("判断用户是否有访问资源的权限的拦截器");
		if(configAttributes == null) {
			return;
		}
		//所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while(iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			//访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();
			System.out.println("需要的权限是:" + needPermission);
			
			//用户所拥有的权限authentication
			for(GrantedAuthority ga : authentication.getAuthorities()) {
				System.out.println("得到的权限是:"+ga.getAuthority());
				if(needPermission.equals(ga.getAuthority())) {
					return;
				}
			}
		}
		//没有权限让我们去捕捉
		throw new AccessDeniedException("对不起，没有权限访问！");
		
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
