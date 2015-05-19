package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ray.dao.AlertDao;
import com.ray.entity.Alert;
import com.ray.eye.InfoqMain;

/**
 * 文章的管理控制器
 * @author Ray Wang
 * @date 2015年5月16日22:17:59
 * @version 1.0
 */
@Controller
@RequestMapping("/manager")
public class ManagerAlertCon {

	@Autowired
	private InfoqMain infoq;
	
	@Autowired
	private AlertDao dao;
	
	@RequestMapping("/alert/crawler.do")
	public void crawler(HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			ArrayList<Alert> list = infoq.infoqArticle();
			if(dao.add(list)){
				pw.write("Crawler Success");
			}else{
				pw.write("Crawler Error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public InfoqMain getInfoq() {
		return infoq;
	}
	public void setInfoq(InfoqMain infoq) {
		this.infoq = infoq;
	}
	public AlertDao getDao() {
		return dao;
	}
	public void setDao(AlertDao dao) {
		this.dao = dao;
	}
	
	
}
