package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.UserLogDao;
import com.ray.entity.UserLog;

/**
 * 用户以及用户的登陆日志的控制器
 * @author Ray
 * @date 2015年6月10日17:11:12
 * @version 1.0
 */
@Controller("/admin")
public class UserAndLogController {

	@Autowired
	private UserLogDao logDao;
	
	@RequestMapping("/log/get.do")
	public void findLog(@RequestParam(defaultValue="0")int page,
			@RequestParam(defaultValue="10")int rows,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			List<UserLog> logs = logDao.findByPage(page, rows);
			pw.write(new Gson().toJson(logs));
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
	
	
}
