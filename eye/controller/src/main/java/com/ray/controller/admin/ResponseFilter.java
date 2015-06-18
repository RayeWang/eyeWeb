package com.ray.controller.admin;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

public class ResponseFilter extends SecurityContextHolderAwareRequestFilter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		super.doFilter(request, response, chain);
	}
}
