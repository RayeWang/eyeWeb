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
import com.ray.dao.AlertDao;
import com.ray.entity.Alert;

/**
 * APP的相关接口控制器
 * @author Ray Wang
 * @date 2015年6月24日21:31:58
 * @version 1.0
 */
@Controller("/app")
public class AppController {
	
	@Autowired
	private AlertDao alertDao;
	
	/**
	 * 获取文章接口（未进行加密判断，最初测试的接口）
	 * @param page 当前页的索引
	 * @param rows 每页查询的数据行
	 * @param response 
	 */
	@RequestMapping("/article.do")
	public void getAlert(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="20")int rows,HttpServletResponse response){
		PrintWriter pw = null;
		try {
			List<Alert> list = alertDao.findByAlert(page, rows, 0, "");
			pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AlertDao getAlertDao() {
		return alertDao;
	}

	public void setAlertDao(AlertDao alertDao) {
		this.alertDao = alertDao;
	}
	
	
	
}
