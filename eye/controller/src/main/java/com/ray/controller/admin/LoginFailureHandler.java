package com.ray.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.ray.dao.UserLogDao;
import com.ray.entity.UserLog;
/**
 * 登陆失败的处理部分
 * @author Ray
 * @date 2015年6月11日09:57:10
 * @version 1.0
 */
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	/** 登陆失败进入的网址*/
	private String failUrl;
	@Autowired
	private UserLogDao logDao;
	
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		UserLog log = new UserLog();
		log.setIp(getIpAddress(request));
		log.setIssuccess(0);
		log.setUsername(request.getParameter("username"));
		logDao.add(log);
		getRedirectStrategy().sendRedirect(request, response, failUrl);
	}

	public UserLogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(UserLogDao logDao) {
		this.logDao = logDao;
	}

	
	public String getIpAddress(HttpServletRequest request){    
        String ip = request.getHeader("x-forwarded-for");    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("WL-Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_CLIENT_IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getRemoteAddr();    
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = request.getHeader("WL-Proxy-Client-IP"); 
        }
        if(ip == null || ip.length() == 0){
        	return "未知IP";
        }
        return ip;    
    }

	public String getFailUrl() {
		return failUrl;
	}

	public void setFailUrl(String failUrl) {
		this.failUrl = failUrl;
	}  
	
	
	
}
