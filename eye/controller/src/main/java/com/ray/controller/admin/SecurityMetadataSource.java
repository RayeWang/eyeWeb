package com.ray.controller.admin;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/**
 * 加载所有资源与权限之间的关系拦截器
 * @author Ray
 * @date 2015年5月29日16:50:50
 * @version 1.0
 */
public class SecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	/**
	 * 返回请求资源所需要的权限
	 */
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		System.err.println("requestUrl is " + requestUrl);
		// System.err.println(resourceMap.get(requestUrl));
		if (resourceMap == null) {
			loadResourceDefine();
		}

		return resourceMap.get(requestUrl);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	// 加载所有资源与权限的关系
	private void loadResourceDefine() {
		System.out.println("加载所有资源与权限的关系");
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
			ConfigAttribute configAttribute = new SecurityConfig("ROLE_ADMIN");
			configAttributes.add(configAttribute);
			resourceMap.put("/admin/adminpage.jsp", configAttributes);
		}

	

	}

}
