package com.ray.dao;

import com.ray.entity.Users;

/**
 * 用户的相关数据库操作接口
 * @author Ray Wang
 * @date 2015年6月8日20:41:29
 * @version 1.0
 */
public interface UserDao {

	public Users findByName(String name);
	
	/**
	 * 修改登陆密码
	 * @param pass
	 * @param name
	 */
	public int changePass(String name,String newPass,String oldPass);
}
