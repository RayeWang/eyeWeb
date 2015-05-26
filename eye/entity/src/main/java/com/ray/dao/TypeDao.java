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
	
	/**
	 * 根据分页查询文章分类
	 * @param page 当前页面索引
	 * @param pageSize 
	 * @return
	 */
	public List<AlertType> findByPage(int page,int pageSize);
	
	/** 
	 * 获取总记录数据，用于分页
	 * @return
	 */
	public int getCount();
	
	/**
	 * 更新一个分类
	 * @param type
	 */
	public void update(AlertType type);
	/**
	 * 根据id来删除一个分类
	 * @param id 分类id
	 */
	public void delete(int id);
}
