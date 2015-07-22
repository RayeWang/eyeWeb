package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.CommendDao;
import com.ray.entity.Commend;
import com.ray.entity.mapper.CommendMapper;
import com.ray.entity.mapper.DynamicSql;
/**
 * 意见与建议的接口实现类
 * @author Ray
 * @date 2015年7月22日10:21:44
 * @version 1.0
 */
@Service
public class CommendDaoImpl implements CommendDao {
	
	@Autowired
	private CommendMapper mapper;

	public List<Commend> findByPage(int page, int rows) {
		new DynamicSql().setSql("select id, email, nickname, commend, createtime "
				+ "from commend order by createtime desc limit "+
				(page - 1)*rows+","+rows);
		return mapper.selectByPage();
	}

	public void add(Commend commend) {
		mapper.insert(commend);
	}

	public CommendMapper getMapper() {
		return mapper;
	}

	public void setMapper(CommendMapper mapper) {
		this.mapper = mapper;
	}

	
}
