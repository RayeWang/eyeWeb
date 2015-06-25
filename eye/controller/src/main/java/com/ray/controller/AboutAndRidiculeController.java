package com.ray.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ray.dao.TypeDao;
import com.ray.entity.AlertType;

/**
 * 关于与吐槽的控制器
 * @author Ray
 * @date 2015年6月25日13:18:23
 * @version 1.0
 */
@Controller
public class AboutAndRidiculeController {

	/** 分类的数据库操作接口*/
	@Autowired
	private TypeDao typeDao;
	
	@RequestMapping("about.do")
	public String toAbout(ModelMap map){
		List<AlertType> types = typeDao.findAll();
		//添加一个全部的分类
		types.add(0,new AlertType(0, "全部分类","alert.do"));
		map.addAttribute("typeid", 5);
		//传递参数到页面
		map.addAttribute("types", types);
		return "about";
	}
	
	public TypeDao getTypeDao() {
		return typeDao;
	}
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
	
}
