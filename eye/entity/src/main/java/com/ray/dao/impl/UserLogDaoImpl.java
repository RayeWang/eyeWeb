package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.UserLogDao;
import com.ray.entity.UserLog;
import com.ray.entity.mapper.UserLogMapper;

/**
 * 用户登陆日志的数据库操作接口实现类
 * @author Ray
 * @date 2015年6月10日16:39:45
 * @version 1.0
 */
@Service
public class UserLogDaoImpl implements UserLogDao {

	@Autowired
	private UserLogMapper mapper;
	
	public void add(UserLog log) {
		mapper.insert(log);
	}

	public List<UserLog> findByPage(int page, int rows) {
		return mapper.selectByPage((page - 1) * rows, rows);
	}

	public UserLogMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserLogMapper mapper) {
		this.mapper = mapper;
	}

}
