package com.ray.dao;

import java.util.List;

import com.ray.entity.Css;
import com.ray.entity.ResLink;

/**
 * 样式的相关数据库操作
 * @author Ray Wang
 * @date 2015年6月7日11:02:48
 * @version 1.0
 */
public interface CssDao {

	/**
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Css> findByPage(int page,int rows);
}
