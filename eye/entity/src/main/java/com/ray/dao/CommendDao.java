package com.ray.dao;

import java.util.List;

import com.ray.entity.Commend;

/**
 * 意见与建议的接口
 * @author Ray
 * @date 2015年7月22日10:19:35
 * @version 1.0
 */
public interface CommendDao {

	public List<Commend> findByPage(int page,int rows);
	
	public void add(Commend commend);
}
