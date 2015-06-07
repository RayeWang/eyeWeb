package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.AlertDao;
import com.ray.dao.ResDao;
import com.ray.dao.ResLinkDao;
import com.ray.dao.TypeDao;
import com.ray.entity.Alert;
import com.ray.entity.AlertType;
import com.ray.entity.Res;
import com.ray.entity.ResLink;
import com.ray.eye.CrawlerFactory;

/**
 * 文章的管理控制器
 * @author Ray Wang
 * @date 2015年5月16日22:17:59
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class ManagerAlertCon {
	
	/** 文章的相关操作数据库接口*/
	@Autowired
	private AlertDao dao;
	
	/** 分类来源的相关操作数据库接口*/
	@Autowired
	private ResLinkDao linkDao;
	
	@Autowired
	private ResDao resDao;
	@Autowired
	private TypeDao typeDao;
	
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
				if(list != null && list.size() > 0){
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
	/**
	 * 添加一篇文章
	 * @param alert
	 * @param response
	 */
	@RequestMapping("article/add.do")
	public void add(Alert alert,HttpServletResponse response){
		try {
			Res res = resDao.findByLinkId(alert.getResLinkId());
			alert.setResId(res.getId());
			dao.add(alert);
			PrintWriter pw = response.getWriter();
			pw.write("true");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取文章
	 * @param response
	 * @param page
	 * @param rows
	 */
	@RequestMapping("/article/get.do")
	public void getArticle(HttpServletResponse response,
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows){
		try {
			PrintWriter pw = response.getWriter();
			List<Alert> alerts = dao.findByAlert(page, rows, 0, "");
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("rows", alerts);
			map.put("total", dao.findCount(0, ""));
			pw.write(new Gson().toJson(map));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据id删除文章
	 * @param ids
	 * @param response
	 */
	@RequestMapping("/article/deletebyids.do")
	public void deleteByIds(@RequestParam(defaultValue="")String ids,
			HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			dao.deleteByIds(ids);
			pw.write("true");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 进入添加文章的页面
	 * @param map 传递参数的map
	 * @return
	 */
	@RequestMapping("/article/toadd.do")
	public String toAdd(ModelMap map){
		List<ResLink> links = linkDao.findAll();
		List<AlertType> types = typeDao.findAll();
		
		map.put("links", links);
		map.put("types", types);
		
		return "/admin/article/addarticle";
	}
	/**
	 * 进入文章编辑页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/article/toedit.do")
	public String toEdit(@RequestParam(defaultValue="0")int id,
			ModelMap map){
		Alert alert = dao.findById(id);
		List<ResLink> links = linkDao.findAll();
		List<AlertType> types = typeDao.findAll();
		
		map.put("article", alert);
		map.put("links", links);
		map.put("types", types);
		return "/admin/article/editarticle";
	}
	
	/**
	 * 更新一篇文章
	 * @param alert
	 * @param response
	 */
	@RequestMapping("/article/updata.do")
	public void update(Alert alert,HttpServletResponse response){
		try {
			PrintWriter pw = response.getWriter();
			dao.update(alert);
			pw.write("true");
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
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
	public ResDao getResDao() {
		return resDao;
	}
	public void setResDao(ResDao resDao) {
		this.resDao = resDao;
	}
	public TypeDao getTypeDao() {
		return typeDao;
	}
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
	
}
