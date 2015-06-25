package com.ray.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ray.dao.AlertDao;
import com.ray.dao.TypeDao;
import com.ray.entity.Alert;
import com.ray.entity.AlertType;

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
	
	/** 分类的数据库操作接口*/
	@Autowired
	private TypeDao typeDao;
	
//	response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
	/**
	 * 获取文章列表
	 * @param page 当前第几页
	 * @param response
	 */
	@RequestMapping("/alert.do")
	public String getAlerts(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="0")int typeid,@RequestParam(defaultValue="")String key,
			ModelMap map){
		List<Alert> list = dao.findByAlert( page, pageSize,typeid,key);
		List<AlertType> types = typeDao.findAll();
		//添加一个全部的分类
		types.add(0,new AlertType(0, "全部分类","alert.do"));
		
		//传递参数到页面
		map.addAttribute("types", types);
		map.addAttribute("alerts", list);
		map.addAttribute("typeid", typeid);
		map.addAttribute("key", key);
		map.addAttribute("page", page);
		//查询出总数量，以此来计算最大分页
		int allCount = dao.findCount(typeid, key);
		//最大页数
		int maxPage = allCount / pageSize;
		if(allCount % pageSize > 0){
			maxPage ++;
		}
		map.addAttribute("maxPage", maxPage);
		
		return "index";
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
	
	
	public AlertDao getDao() {
		return dao;
	}
	public void setDao(AlertDao dao) {
		this.dao = dao;
	}
	public TypeDao getTypeDao() {
		return typeDao;
	}
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
	
	
}
