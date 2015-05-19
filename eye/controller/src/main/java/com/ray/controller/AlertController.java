package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.AlertDao;
import com.ray.entity.Alert;

/**
 * 文章的客户浏览的主要控制器
 * @author Ray Wang
 * @date 2015年5月17日10:26:37
 * @version 1.0
 */
@Controller
public class AlertController {

	/** 每页显示的数量*/
	private int pageSize = 20;
	
	/** 数据库访问接口*/
	@Autowired
	private AlertDao dao;
	
//	response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
	/**
	 * 获取文章列表
	 * @param page 当前第几页
	 * @param response
	 */
	@RequestMapping("/alert.do")
	public String getAlerts(@RequestParam(defaultValue="1")int page,HttpServletRequest request){
		List<Alert> list = dao.findByAlert( page, pageSize);
		request.setAttribute("alerts", list);
		return "index";
	}
	public AlertDao getDao() {
		return dao;
	}
	public void setDao(AlertDao dao) {
		this.dao = dao;
	}
	
	/**
	 * 根据id显示文章
	 * @param id 文章id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getalert.do")
	public String getAlertByid(int id,HttpServletRequest request){
		Alert alert = dao.findById(id);
		request.setAttribute("alert", alert);
		return "alert";
	}
	
}
