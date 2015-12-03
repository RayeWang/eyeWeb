package com.ray.dao;

import java.util.List;

import com.ray.entity.Favorites;

/**
 * 收藏的相关数据库操作接口
 * @author Raye
 * @date 2015年11月26日13:38:26
 */
public interface FavoritesDao {

	/**
	 * 添加收藏
	 * @param openid 用户的openid
	 * @param url 文章的网址
	 */
	public void addFavorite(String openid,String url);
	/**
	 * 删除收藏
	 * @param id 收藏的id
	 */
	public void deleteFavorite(int id,String oepnid);
	
	/**
	 * 获取有多少个收藏
	 * @param openid
	 * @return
	 */
	public int getCount(String openid);
	/**
	 * 查询收藏
	 * @param page 当前页
	 * @param rows 每页的数量
	 * @return 
	 */
	public List<Favorites> findFavorites(int id,String openid);
}
