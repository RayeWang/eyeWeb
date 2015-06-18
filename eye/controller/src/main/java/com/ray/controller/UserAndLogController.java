package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.UserDao;
import com.ray.dao.UserLogDao;
import com.ray.entity.UserLog;

/**
 * 用户以及用户的登陆日志的控制器
 * @author Ray
 * @date 2015年6月10日17:11:12
 * @version 1.0
 */
@RequestMapping("/admin")
@Controller
public class UserAndLogController {

	@Autowired
	private UserLogDao logDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Md5PasswordEncoder md5;
	
	@RequestMapping("/log/get.do")
	public void findLog(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			HashMap<String, Object> map = new HashMap<String, Object>();
			List<UserLog> logs = logDao.findByPage(page, rows);
			int count = logDao.getAllCount();
			
			map.put("rows", logs);
			map.put("total", count);
			pw.write(new Gson().toJson(map));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改密码
	 * @param old
	 * @param newPass
	 * @param response
	 */
	@RequestMapping("/user/changepass.do")
	public void changePass(@RequestParam(defaultValue="")String old,
			@RequestParam(defaultValue="")String newPass,
			HttpServletResponse response){
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String name = auth.getName(); //get logged in username

			PrintWriter pw = response.getWriter();
			
		    if(userDao.changePass(name, md5.encodePassword(newPass, null), 
		    		md5.encodePassword(old, null))>0){

				pw.write("true");
		    }else{
		    	pw.write("false");
		    }
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public UserLogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(UserLogDao logDao) {
		this.logDao = logDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Md5PasswordEncoder getMd5() {
		return md5;
	}

	public void setMd5(Md5PasswordEncoder md5) {
		this.md5 = md5;
	}
	
	
}
