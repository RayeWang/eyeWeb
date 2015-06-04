package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
			response.setHeader("X-Frame-Options", "SAMEORIGIN");
			PrintWriter pw = response.getWriter();
			if(dao.addRes(res)){
				pw.write("0");
			}else{
				pw.write("1");
			}
			pw.close();
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
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加一个分类来源
	 * @param link 分类来源
	 * @param response
	 */
	@RequestMapping("/reslink/add.do")
	public void addResLink(ResLink link,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			if(linkDao.addLink(link)){
				pw.write("add Success");
			}else{
				pw.write("add Error");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加一个分类
	 * @param type
	 * @param response
	 */
	@RequestMapping("/type/add.do")
	public void addType(AlertType type,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			if(typeDao.addType(type)){
				pw.write("add Success");
			}else{
				pw.write("add Error");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据分页获取来源网站
	 * @param response
	 * @param page
	 * @param rows
	 */
	@RequestMapping("/res/get.do")
	public void getRes(HttpServletResponse response,@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows){
		try {
			
			PrintWriter pw = response.getWriter();
			List<Res> res = resDao.findByPage(page, rows);
			pw.write(new Gson().toJson(res));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getResLink(HttpServletResponse response,@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows){
		try {
			PrintWriter pw = response.getWriter();
			List<ResLink> links = linkDao.findByPage(page, rows);
			pw.write(new Gson().toJson(links));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入来源添加页面
	 * @param map
	 * @return
	 */
	@RequestMapping("/res/toadd.do")
	public String toAddRes(ModelMap map){
		
		List<AlertType> types = typeDao.findAll();
		map.put("types", types);
		return "/admin/editoradd";
	}
	
	/**
	 * 前往修改来源页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/res/toedit.do")
	public String toEditRes(@RequestParam(defaultValue="0")int id,
			ModelMap map){
		Res res = resDao.findById(id);
		List<AlertType> types = typeDao.findAll();
		map.put("types", types);
		map.put("res", res);
		return "/admin/editoradd";
	}
	
	/**
	 * 更新一个来源
	 * @param res
	 * @param response
	 */
	@RequestMapping("/res/update.do")
	public void updateRes(Res res,HttpServletResponse response){
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			resDao.update(res);
			pw.write("0");
			pw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(pw != null){
			pw.write("1");
			pw.close();
		}
		
	}
	
	@RequestMapping("res/deletebyids.do")
	public void deleteResByIds(@RequestParam(defaultValue="")String id,HttpServletResponse response){
		PrintWriter pw = null;
		try {
			
			pw = response.getWriter();
			resDao.deleteByIds(id);
			pw.write("0");
			pw.close();
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.write("1");
		pw.close();
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
