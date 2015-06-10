package com.ray.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.ray.dao.UserLogDao;
import com.ray.entity.UserLog;
/**
 * 登陆成功后的处理
 * @author Ray Wang
 * @date 2015年5月28日20:36:57
 * @version 1.0
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	private String defaultTargetUrl;
	
	@Autowired
	private UserLogDao logDao;

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		UserLog log = new UserLog();
		log.setUsername(authentication.getName());
		log.setIssuccess(1);
		log.setIp(getRemortIP(request));
		System.out.println(log.getId());
		System.out.println("登陆成功："+authentication.getName());
		if (savedRequest == null) {
			super.onAuthenticationSuccess(request, response, authentication);

			return;
		}
		String targetUrlParameter = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParameter != null && StringUtils.hasText(request
						.getParameter(targetUrlParameter)))) {
			requestCache.removeRequest(request, response);
			super.onAuthenticationSuccess(request, response, authentication);

			return;
		}
		
		if(requestCache == null){
			getRedirectStrategy().sendRedirect(request, response, defaultTargetUrl);
		}
		
		clearAuthenticationAttributes(request);

		// Use the DefaultSavedRequest URL
		String targetUrl = savedRequest.getRedirectUrl();
		logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}
	
	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}

	public UserLogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(UserLogDao logDao) {
		this.logDao = logDao;
	}
	
	public String getRemortIP(HttpServletRequest request) {

		if (request.getHeader("x-forwarded-for") == null) {

			return request.getRemoteAddr();

		}

		return request.getHeader("x-forwarded-for");

	} 
	
}
