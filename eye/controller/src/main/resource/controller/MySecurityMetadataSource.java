package com.ray.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import zy.bean.Resources;
import zy.system.business.ResourcesBusiness;
import zy.system.dao.ResourcesDao;



//1 加载资源与权限的对应关系

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	//由spring调用
	
	@Autowired
	private ResourcesBusiness resourcesBusiness;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;


	public ResourcesBusiness getResourcesBusiness() {
		return resourcesBusiness;
	}

	public void setResourcesBusiness(ResourcesBusiness resourcesBusiness) {
		this.resourcesBusiness = resourcesBusiness;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
	//加载所有资源与权限的关系
	private void loadResourceDefine() {
		if(resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Resources> resources = this.resourcesBusiness.findAll();
			for (Resources resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				//以权限名封装为Spring的security Object
				ConfigAttribute configAttribute = new SecurityConfig(resource.getResourceName());
				configAttributes.add(configAttribute);
				resourceMap.put(resource.getResourceUrl(), configAttributes);
			}
		}
		
		Set<Entry<String, Collection<ConfigAttribute>>> resourceSet = resourceMap.entrySet();
		Iterator<Entry<String, Collection<ConfigAttribute>>> iterator = resourceSet.iterator();
		
	}
	//返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		System.err.println("requestUrl is " + requestUrl);
	//	System.err.println(resourceMap.get(requestUrl));
		if(resourceMap == null) {
			loadResourceDefine();
		}
		
		return resourceMap.get(requestUrl);
	}

}
