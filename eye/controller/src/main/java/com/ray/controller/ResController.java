package com.ray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ray.dao.ResDao;

/**
 * 来源网站相关请求控制器
 * @author Ray
 * @date 2015年5月15日17:40:54
 * @version 1.0
 */
@Controller
public class ResController {
	@Autowired
	private ResDao dao;


	
	public ResDao getDao() {
		return dao;
	}

	public void setDao(ResDao dao) {
		this.dao = dao;
	}
	
	
	
}
