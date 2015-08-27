package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.AppVersionDao;
import com.ray.entity.Appversion;

@Controller
@RequestMapping("/admin/version")
public class APPVersionController {

	@Autowired
	private AppVersionDao dao;
	
	@RequestMapping("/get.do")
	public void getAll(HttpServletResponse response){
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(new Gson().toJson(dao.findAll()));
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(pw != null){
				pw.close();
			}
		}
	}
	@RequestMapping("/toedit.do")
	public String toEdit(@RequestParam(defaultValue="0")int id,ModelMap map){
		map.put("version", dao.findById(id));
		return "/admin/version/edit";
	}
	
	@RequestMapping("/add.do")
	public void add(Appversion appversion,HttpServletResponse response){
		
		try {
			PrintWriter pw = response.getWriter();
			if(dao.add(appversion)){

				pw.write("true");
			}else{
				pw.write("false");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/update.do")
	public void update(Appversion appversion,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			if(dao.update(appversion)){

				pw.write("true");
			}else{
				pw.write("false");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public AppVersionDao getDao() {
		return dao;
	}

	public void setDao(AppVersionDao dao) {
		this.dao = dao;
	}
	
	
}
