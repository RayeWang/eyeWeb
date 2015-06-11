package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

	public void changePass(@RequestParam(defaultValue="")String old,
			@RequestParam(defaultValue="")String newPass,
			HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
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
	
	
}
