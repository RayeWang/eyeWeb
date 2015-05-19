package com.ray.dao;

import java.util.List;

import com.ray.entity.AlertType;

/**
 * 文章类型的数据库操作接口
 * @author Ray Wang
 * @date 2015年5月19日20:52:30
 * @version 1.0
 */
public interface TypeDao {

	/**
	 * 添加一个文章类型
	 * @param type 文章类型
	 * @return
	 */
	public boolean addType(AlertType type);
	
	/**
	 * 查询所有文章类型
	 * @return
	 */
	public List<AlertType> findAll();
}
