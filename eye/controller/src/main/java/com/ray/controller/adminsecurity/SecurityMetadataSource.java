package com.ray.controller.adminsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/**
 * 资源与权限之间的关系
 * @author Ray
 * @date 2015年5月28日15:51:20
 * @version 1.0
 */
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	private ArrayList<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
	{
		configAttributes.add(new ConfigAttribute() {
			
			public String getAttribute() {
				return "ROLE_ADMIN";
			}
		});
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		resourceMap.put("/admin/adminpage.jsp", configAttributes);
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		return resourceMap.get(requestUrl);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
