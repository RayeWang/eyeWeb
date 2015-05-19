package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.ray.dao.ResDao;
import com.ray.entity.Res;

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

	/**
	 * 添加一个来源
	 * @param res
	 * @param response
	 */
	@RequestMapping("/manager/res/addres.do")
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
	@RequestMapping("/manager/res/findall.do")
	public void findAll(HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			List<Res> list = dao.findAll();
			pw.write(new Gson().toJson(list));
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
	
	
	
}
