package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.UserDao;
import com.ray.entity.Users;
import com.ray.entity.UsersCriteria;
import com.ray.entity.mapper.UsersMapper;
/**
 * 用户表数据库操作相关接口实现类
 * @author Ray Wang
 * @date 2015年6月8日20:43:03
 * @version 1.0
 */
@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UsersMapper mapper;
	
	public Users findByName(String name) {
		UsersCriteria criteria = new UsersCriteria();
		criteria.createCriteria().andUsernameEqualTo(name);
		List<Users> users = mapper.selectByExample(criteria);
		if(users != null && users.size() > 0){
			return users.get(0);
		}
		return null;
	}

	public UsersMapper getMapper() {
		return mapper;
	}

	public void setMapper(UsersMapper mapper) {
		this.mapper = mapper;
	}

}
