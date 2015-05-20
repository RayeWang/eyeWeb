package com.ray.dao;

import java.util.List;

import com.ray.entity.Alert;

/**
 * 文章相关操作的数据库接口
 * @author Ray Wang
 * @date 2015年5月16日21:08:03
 * @version 1.0
 */
public interface AlertDao {

	/**
	 * 添加文章
	 * @param list 列表
	 */
	public void add(List<Alert> list);
	
	/**
	 * 根据模板查询文章
	 * @param alert 文章模板
	 * @return 文章集合
	 */
	public List<Alert> findByAlert(int page,int pageSize);
	
	/**
	 * 根据ID查询文章
	 * @param id 文章的id
	 * @return
	 */
	public Alert findById(int id);
}
