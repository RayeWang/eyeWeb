package com.ray.dao;

import com.ray.entity.Appusers;

/**
 * APP用户的数据库操作相关接口
 * @author Raye
 * @date 2015年12月10日13:08:53
 */
public interface APPUserDao {

	/**
	 * 添加一个用户记录，登陆的时候都添加
	 * 调用存储过程，不会重复插入
	 * @param appusers
	 */
	public void insert(Appusers appusers);
	
	/**
	 * 获取用户信息
	 * @param openid
	 * @return
	 */
	public Appusers selectByOpenid(String openid);
}
