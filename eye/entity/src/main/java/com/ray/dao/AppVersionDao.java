package com.ray.dao;

import java.util.List;

import com.ray.entity.Appversion;

/**
 * APP版本相关处理数据库接口
 * @author Ray
 * @date 2015年8月27日14:35:18
 * @version 1.0
 */
public interface AppVersionDao {

	/**
	 * 添加一条记录
	 * @param appversion
	 * @return
	 */
	public boolean add(Appversion appversion);
	/**
	 * 更新一条记录
	 * @param appversion
	 * @return
	 */
	public boolean update(Appversion appversion);
	/** 
	 * 查询所有版本信息
	 * @return
	 */
	public List<Appversion> findAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Appversion findById(int id);
	/**
	 * 根据平台查询
	 * @param type
	 * @return
	 */
	public Appversion findByType(int type);
}
