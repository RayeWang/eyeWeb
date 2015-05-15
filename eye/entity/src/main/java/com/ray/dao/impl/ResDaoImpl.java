package com.ray.dao.impl;

import org.springframework.stereotype.Service;

import com.ray.dao.ResDao;
import com.ray.entity.Res;
import com.ray.entity.mapper.ResMapper;
/**
 * 来源网站数据库操作实现接口
 * @author Ray
 * @date 2015年5月15日17:37:36
 */
@Service("ResDaoImpl")
public class ResDaoImpl implements ResDao {

	private ResMapper mapper;
	
	public boolean addRes(Res res) {
		if(mapper.insert(res) > 0){
			return true;
		}
		return false;
	}

	public ResMapper getMapper() {
		return mapper;
	}

	public void setMapper(ResMapper mapper) {
		this.mapper = mapper;
	}

	

	
}
