package com.ray.dao;

import java.util.List;

import com.ray.entity.Res;


/**
 * 来源网站的相关数据数据库操作接口
 * @author Ray
 * @date 2015年5月15日17:24:39
 * @version 1.0
 */
public interface ResDao {

	/**
	 * 添加一个来源网站
	 * @param res 来源网站对象
	 * @return 时候添加成功
	 */
	public boolean addRes(Res res);
	
	/**
	 * 查询所有来源
	 * @return
	 */
	public List<Res> findAll();
}
