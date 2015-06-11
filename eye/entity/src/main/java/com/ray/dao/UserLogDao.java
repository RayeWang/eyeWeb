package com.ray.dao;

import java.util.List;

import com.ray.entity.UserLog;

/**
 * 后台用户登录日志的数据库操作接口
 * @author Ray
 * @date 2015年6月10日16:18:34
 * @version 1.0
 */
public interface UserLogDao {

	/**
	 * 添加一个日志
	 * @param log
	 */
	public void add(UserLog log);
	
	/**
	 * 根据分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<UserLog> findByPage(int page,int rows);
	/**
	 * 获取总记录数，用于分页数据
	 * @return
	 */
	public int getAllCount();
}
