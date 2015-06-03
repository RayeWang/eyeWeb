package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.ResDao;
import com.ray.dao.ResLinkDao;
import com.ray.dao.TypeDao;
import com.ray.entity.AlertType;
import com.ray.entity.Res;
import com.ray.entity.ResLink;

/**
 * 来源网站相关请求控制器
 * @author Ray
 * @date 2015年5月15日17:40:54
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class ResController {
	/** 来源网站的数据库操作接口*/
	@Autowired
	private ResDao dao;
	/** 来源分类的数据库操作接口*/
	@Autowired
	private ResLinkDao linkDao;
	
	/** 文章分类的数据库操作接口*/
	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private ResDao resDao;

	/**
	 * 添加一个来源
	 * @param res
	 * @param response
	 */
	@RequestMapping("/res/addres.do")
	public void addRes(Res res,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			if(dao.addRes(res)){
				pw.write("Add Success");
			}else{
				pw.write("Add Error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有来源
	 * @param response
	 */
	@RequestMapping("/res/findall.do")
	public void findAll(HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			List<Res> list = dao.findAll();
			pw.write(new Gson().toJson(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/reslink/add.do")
	public void addResLink(ResLink link,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			if(linkDao.addLink(link)){
				pw.write("add Success");
			}else{
				pw.write("add Error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/type/add.do")
	public void addType(AlertType type,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			if(typeDao.addType(type)){
				pw.write("add Success");
			}else{
				pw.write("add Error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/res/get.do")
	public void getRes(HttpServletResponse response,@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows){
		try {
			
			response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
			PrintWriter pw = response.getWriter();
			List<Res> res = resDao.findByPage(page, rows);
			pw.write(new Gson().toJson(res));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ResDao getDao() {
		return dao;
	}

	public void setDao(ResDao dao) {
		this.dao = dao;
	}

	public ResLinkDao getLinkDao() {
		return linkDao;
	}

	public void setLinkDao(ResLinkDao linkDao) {
		this.linkDao = linkDao;
	}

	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public ResDao getResDao() {
		return resDao;
	}

	public void setResDao(ResDao resDao) {
		this.resDao = resDao;
	}
	
	
	
}
