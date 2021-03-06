package com.ray.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ray.dao.APPUserDao;
import com.ray.dao.AlertDao;
import com.ray.dao.AppVersionDao;
import com.ray.dao.CommendDao;
import com.ray.dao.FavoritesDao;
import com.ray.dao.TypeDao;
import com.ray.entity.Alert;
import com.ray.entity.AlertType;
import com.ray.entity.Appusers;
import com.ray.entity.Appversion;
import com.ray.entity.ArticleResult;
import com.ray.entity.Commend;
import com.ray.entity.Favorites;
import com.ray.entity.JsonResult;
import com.ray.util.MD5Util;

/**
 * APP的相关接口控制器
 * @author Ray Wang
 * @date 2015年6月24日21:31:58
 * @version 1.0
 */
@RequestMapping("/app")
@Controller()
public class AppController {
	
	public static int count = 0;
	
	
	@Autowired
	private AlertDao alertDao;
	
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private CommendDao commendDao;
	@Autowired
	private AppVersionDao versionDao;
	@Autowired
	private FavoritesDao favoritesDao;
	
	@Autowired
	private APPUserDao appuserDao;
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
			response.setContentType("application/json;charset=UTF-8");
			pw = response.getWriter();

			if(count > 500){
				ArticleResult result = new ArticleResult("2", "接口调用超过当日次数限制");
				pw.write(new Gson().toJson(result));
				pw.close();
				return;
			}

			count++;
			//查询出数据
			List<Alert> list = alertDao.findByAlertNoId(page, rows, type, key);
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
			e.printStackTrace();
			if(pw != null){
				ArticleResult result = new ArticleResult("1", "服务器异常");
				pw.write(new Gson().toJson(result));
				pw.close();
			}
		}
	}
	
	/**
	 * 获取文章接口（未进行加密判断，最初测试的接口）
	 * @param page 当前页的索引
	 * @param rows 每页查询的数据行
	 * @param response 
	 */
	@RequestMapping("/article1.do")
	public void getAlert1(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="20")int rows,
			@RequestParam(defaultValue="0")int type,
			@RequestParam(defaultValue="")String key,
			@RequestParam(defaultValue="")String token,HttpServletResponse response){
		PrintWriter pw = null;
		try {
			response.setContentType("application/json;charset=UTF-8");
			pw = response.getWriter();
			
			if(!"".equals(token)){
				//验证是否正确的md5
				String temp = token.substring(0, 24);
				//随机数的md5值
				String rand = token.substring(24);
				if(MD5Util.md5(rand+"typeid="+type+"&page="+page).substring(0, 24).equals(temp.toUpperCase())){
					//验证成功
					//查询出数据
					List<Alert> list = alertDao.findByAlertNoId(page, rows, type, key);
					int count = alertDao.findCount(type, key);

					ArticleResult result = new ArticleResult();
					result.setCount(count);
					result.setData(list);
					
					pw.write(new Gson().toJson(result));
					pw.close();
					return;
				}
			}
			ArticleResult result = new ArticleResult("2", "请不要尝试破解接口，谢谢");
			pw.write(new Gson().toJson(result));
			pw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
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
			response.setContentType("application/json;charset=UTF-8");
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
	
	
	/**
	 * 根据url显示文章
	 * @param url 文章url
	 * @param request
	 * @return
	 */
	@RequestMapping("/getalert.do")
	public String getAlertByUrl(@RequestParam(defaultValue="")String url,
			HttpServletRequest request,@RequestParam(defaultValue="false")boolean isBlack){
		if(count > 500){
			return "alert";
		}
		count++;
		Alert alert = alertDao.findByUrl(url);
		request.setAttribute("alert", alert);

		request.setAttribute("isblack", isBlack);
		return "alert";
	}
	
	/**
	 * 根据url显示文章
	 * @param url 文章url
	 * @param request
	 * @return
	 */
	@RequestMapping("/getalert1.do")
	public String getAlertByUrl1(@RequestParam(defaultValue="")String url,
			HttpServletRequest request,@RequestParam(defaultValue="")String token,
			HttpServletResponse response,
			@RequestParam(defaultValue="false")boolean isBlack){
		if(!"".equals(token)){
			//验证是否正确的md5
			String temp = token.substring(0, 24);
			//随机数的md5值
			String rand = token.substring(24);
			if(MD5Util.md5(rand+url).substring(0, 24).equals(temp.toUpperCase())){
				//验证成功
				Alert alert = alertDao.findByUrl(url);
				request.setAttribute("alert", alert);
				request.setAttribute("isblack", isBlack);
				return "alert";
			}
		}
		//验证失败了的
		
		
		return "tokenerror";
	}
	
	
	/**
	 * 开放的意见与建议接口
	 * @param commend
	 * @param response
	 */
	@RequestMapping("/commend.do")
	public void commend(Commend commend,HttpServletResponse response){
		PrintWriter pw = null;

		response.setContentType("application/json;charset=UTF-8");
		try{
			pw = response.getWriter();
			if(count >= 500){
				ArticleResult result = new ArticleResult("2", "接口调用超过当日次数限制");
				pw.write(new Gson().toJson(result));
				pw.close();
				return;
			}
			if(commend != null && commend.getEmail() != null && !commend.getEmail().isEmpty()
					&& commend.getCommend() != null && !commend.getCommend().isEmpty()){
				commendDao.add(commend);
				JsonResult jsonResult = new JsonResult("","建议成功");
				pw.write(new Gson().toJson(jsonResult));
				pw.close();
			}else{
				JsonResult jsonResult = new JsonResult("1","建议失败");
				pw.write(new Gson().toJson(jsonResult));
				pw.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 开放的意见与建议接口
	 * @param commend
	 * @param response
	 */
	@RequestMapping("/commend1.do")
	public void commend1(Commend commend,HttpServletResponse response,
			@RequestParam(defaultValue="")String token){
		PrintWriter pw = null;
		response.setContentType("application/json;charset=UTF-8");
		try{
			pw = response.getWriter();
			
			if(!"".equals(token)&& commend != null && commend.getEmail() != null && !commend.getEmail().isEmpty()
					&& commend.getCommend() != null && !commend.getCommend().isEmpty()){
				//验证是否正确的md5
				String temp = token.substring(0, 24);
				//随机数的md5值
				String rand = token.substring(24);
				if(MD5Util.md5(rand+"email="+commend.getEmail()).substring(0, 24).equals(temp.toUpperCase())){
					commendDao.add(commend);
					JsonResult jsonResult = new JsonResult("","建议成功");
					pw.write(new Gson().toJson(jsonResult));
					pw.close();
					return;
				}
				
			}
			ArticleResult result = new ArticleResult("2", "请不要尝试破解接口，谢谢");
			pw.write(new Gson().toJson(result));
			pw.close();
			return;
			
		}catch(Exception e){
			e.printStackTrace();
			if(pw != null){
				pw.close();
			}
		}
	}
	
	@RequestMapping("/checkVersion.do")
	public void getNewVersion(@RequestParam(defaultValue="1")int type,
			HttpServletResponse response){

		PrintWriter pw = null;
		response.setContentType("application/json;charset=UTF-8");
		try{
			pw = response.getWriter();
			Appversion appversion = versionDao.findByType(type);
			if(appversion != null){
				JsonResult jsonResult = new JsonResult("","获取成功");
				jsonResult.setData(appversion);
				pw.write(new Gson().toJson(jsonResult));
			}else{
				ArticleResult result = new ArticleResult("1", "没有获取到信息");
				pw.write(new Gson().toJson(result));
			}
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * 获取收藏列表
	 * @param page
	 * @param rows
	 * @param openid
	 * @param response
	 */
	@RequestMapping("/getfavorites.do")
	public void getFavorites(@RequestParam(defaultValue="1")int id,@RequestParam(defaultValue="")String openid,
			HttpServletResponse response){
		PrintWriter pw = null;
		response.setContentType("application/json;charset=UTF-8");
		if(!"".equals(openid)){
			try {
				pw = response.getWriter();
				List<Favorites> favorites = favoritesDao.findFavorites(id, openid);
				if(favorites != null){
					ArticleResult result = new ArticleResult();
					result.setData(favorites);
					pw.write(new Gson().toJson(result));
				}else{
					ArticleResult result = new ArticleResult("", "没有数据");
					pw.write(new Gson().toJson(result));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(pw != null){
					pw.close();
				}
			}
		}
	}
	/**
	 * 删除收藏
	 * @param id
	 * @param openid
	 * @param response
	 */
	@RequestMapping("/delfavorites.do")
	public void deleteFavorites(@RequestParam(defaultValue="0")int id,
			@RequestParam(defaultValue="")String openid,
			HttpServletResponse response){
		PrintWriter pw = null;
		response.setContentType("application/json;charset=UTF-8");
		try {
			pw = response.getWriter();
			if("".equals(openid) || id == 0){
				ArticleResult result = new ArticleResult("1", "删除失败");
				pw.write(new Gson().toJson(result));
			}else{
				favoritesDao.deleteFavorite(id, openid);
				ArticleResult result = new ArticleResult("", "删除成功");
				pw.write(new Gson().toJson(result));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * 添加收藏
	 * @param openid
	 * @param url
	 * @param response
	 */
	@RequestMapping("/addfavorites.do")
	public void addFavorites(@RequestParam(defaultValue="")String openid,
			@RequestParam(defaultValue="")String url,HttpServletResponse response){
		PrintWriter pw = null;
		response.setContentType("application/json;charset=UTF-8");
		try {
			pw = response.getWriter();
			if("".equals(openid) || "".equals(url)){
				ArticleResult result = new ArticleResult("1", "收藏失败");
				pw.write(new Gson().toJson(result));
			}else{
				favoritesDao.addFavorite(openid, url);
				ArticleResult result = new ArticleResult("", "收藏成功");
				pw.write(new Gson().toJson(result));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * APP用户登陆
	 * @param appusers
	 * @param response
	 */
	@RequestMapping("/login.do")
	public void appLogin(Appusers appusers,HttpServletResponse response){
		PrintWriter pw = null;
		response.setContentType("application/json;charset=UTF-8");
		try {
			pw = response.getWriter();
			if(appusers == null || "".equals(appusers.getOpenid()) ||
					"".equals(appusers.getAccesstoken()) ||
					"".equals(appusers.getExpiresin())){
				ArticleResult result = new ArticleResult("1", "登陆失败");
				pw.write(new Gson().toJson(result));
			}else{
				appuserDao.insert(appusers);
				ArticleResult result = new ArticleResult("", "登陆成功");
				pw.write(new Gson().toJson(result));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * 获取用户信息
	 * @param openid
	 * @param response
	 */
	@RequestMapping("/getappuser.do")
	public void getAppUser(@RequestParam(defaultValue="")String openid,
			HttpServletResponse response){
		PrintWriter pw = null;
		response.setContentType("application/json;charset=UTF-8");
		try{
			pw = response.getWriter();
			if("".equals(openid)){
				JsonResult result = new JsonResult("1", "参数不确");
				pw.write(new Gson().toJson(result));
			}else{
				Appusers appusers = appuserDao.selectByOpenid(openid);
				JsonResult result = null;
				if(appusers != null){
					result = new JsonResult("", "获取成功");
					result.setData(appusers);
				}else{
					result = new JsonResult("2", "获取用户资料失败");
				}
				pw.write(new Gson().toJson(result));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pw != null){
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

	public CommendDao getCommendDao() {
		return commendDao;
	}

	public void setCommendDao(CommendDao commendDao) {
		this.commendDao = commendDao;
	}

	public AppVersionDao getVersionDao() {
		return versionDao;
	}

	public void setVersionDao(AppVersionDao versionDao) {
		this.versionDao = versionDao;
	}
	
	
}
