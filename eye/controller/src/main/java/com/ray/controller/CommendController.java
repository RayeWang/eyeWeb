package com.ray.controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.CommendDao;

@RequestMapping("/admin")
@Controller
public class CommendController {

	@Autowired
	private CommendDao commendDao;
	
	@RequestMapping("/commend.do")
	public void findAll(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="20")int rows,
			HttpServletResponse response){
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("count", commendDao.getCount());
			map.put("rows", commendDao.findByPage(page, rows));
			pw.write(new Gson().toJson(map));
		} catch (Exception e) {
			e.printStackTrace();
			if(pw != null){
				pw.close();
			}
		}
	}

	public CommendDao getCommendDao() {
		return commendDao;
	}

	public void setCommendDao(CommendDao commendDao) {
		this.commendDao = commendDao;
	}
	
	
}
