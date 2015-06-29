package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.AlertDao;
import com.ray.dao.TypeDao;
import com.ray.entity.Alert;
import com.ray.entity.AlertType;
import com.ray.entity.ArticleResult;
import com.ray.entity.JsonResult;

/**
 * APP的相关接口控制器
 * @author Ray Wang
 * @date 2015年6月24日21:31:58
 * @version 1.0
 */
@Controller("/app")
public class AppController {
	
	@Autowired
	private AlertDao alertDao;
	
	@Autowired
	private TypeDao typeDao;
	
	/**
	 * 获取文章接口（未进行加密判断，最初测试的接口）
	 * @param page 当前页的索引
	 * @param rows 每页查询的数据行
	 * @param response 
	 */
	@RequestMapping("/article.do")
	public void getAlert(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="20")int rows,
			@RequestParam(defaultValue="0")int type,
			@RequestParam(defaultValue="")String key,HttpServletResponse response){
		PrintWriter pw = null;
		try {

			pw = response.getWriter();
			//查询出数据
			List<Alert> list = alertDao.findByAlert(page, rows, type, key);
			int count = alertDao.findCount(type, key);
			
			ArticleResult result = new ArticleResult();
			result.setCount(count);
			result.setData(list);
			
			pw.write(new Gson().toJson(result));
			pw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			if(pw != null){
				ArticleResult result = new ArticleResult("1", "服务器异常");
				pw.write(new Gson().toJson(result));
				pw.close();
			}
		}
	}
	
	/**
	 * 获取分类的接口
	 * @param response
	 */
	@RequestMapping("/gettype.do")
	public void getType(HttpServletResponse response){
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			List<AlertType> types = typeDao.findAll();
			JsonResult result = new JsonResult(types);
			pw.write(new Gson().toJson(result));
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			if(pw != null){
				pw.write(new Gson().toJson(new JsonResult("1","服务器异常")));
				pw.close();
			}
		}
	}
	

	public AlertDao getAlertDao() {
		return alertDao;
	}

	public void setAlertDao(AlertDao alertDao) {
		this.alertDao = alertDao;
	}

	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
	
	
}
