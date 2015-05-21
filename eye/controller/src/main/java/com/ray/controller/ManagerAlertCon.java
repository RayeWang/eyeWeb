package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ray.dao.AlertDao;
import com.ray.dao.ResLinkDao;
import com.ray.entity.Alert;
import com.ray.entity.ResLink;
import com.ray.eye.CrawlerFactory;

/**
 * 文章的管理控制器
 * @author Ray Wang
 * @date 2015年5月16日22:17:59
 * @version 1.0
 */
@Controller
@RequestMapping("/manager")
public class ManagerAlertCon {
	
	/** 文章的相关操作数据库接口*/
	@Autowired
	private AlertDao dao;
	
	/** 分类来源的相关操作数据库接口*/
	@Autowired
	private ResLinkDao linkDao;
	
	/**
	 * 启用爬虫
	 * 先查询出所有的来源分类，然后在爬虫工厂类中创建相应的爬虫爬取数据
	 * 因为每次都有可能失败，所以每个来源创建爬取完成后保存一次数据库，将错误将到最低
	 * @param response
	 */
	@RequestMapping("/alert/crawler.do")
	public void crawler(HttpServletResponse response){
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			
			List<ResLink> links = linkDao.findAll();
			for(ResLink link : links){
				ArrayList<Alert> list = new CrawlerFactory().crawlerFactory(link);
				if(list.size() > 0){
					dao.add(list);
				}
			}
			pw.write("Crawler Success");
			
			return;
		} catch (IOException e ) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(pw != null){
			pw.write("Crawler Error");
		}
	}
	

	public AlertDao getDao() {
		return dao;
	}
	public void setDao(AlertDao dao) {
		this.dao = dao;
	}


	public ResLinkDao getLinkDao() {
		return linkDao;
	}


	public void setLinkDao(ResLinkDao linkDao) {
		this.linkDao = linkDao;
	}
	
	
}
