package com.ray.controller.admin;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
/**
 * 不知道是干嘛用的，需要继续研究
 * @author Ray
 * @date 2015年6月1日11:05:31
 */
public class MyAuthenticationManager implements AuthenticationManager {

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		return null;
	}

}
