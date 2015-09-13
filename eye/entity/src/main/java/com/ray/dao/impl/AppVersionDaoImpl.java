package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.AppVersionDao;
import com.ray.entity.Appversion;
import com.ray.entity.AppversionCriteria;
import com.ray.entity.mapper.AppversionMapper;
/**
 * App版本控制相关数据库操作实现类
 * @author Ray
 * @date 2015年8月27日14:37:58
 * @version 1.0
 */
@Service
public class AppVersionDaoImpl implements AppVersionDao {

	@Autowired
	private AppversionMapper mapper;
	public boolean add(Appversion appversion) {
		try {
			mapper.insert(appversion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Appversion appversion) {
		try {
			mapper.updateByPrimaryKey(appversion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	public Appversion findByType(int type) {
		AppversionCriteria criteria = new AppversionCriteria();
		criteria.createCriteria().andNametypeEqualTo(type);
		List<Appversion> list = mapper.selectByExample(criteria);
		if(list.size() > 0 ){
			return list.get(0);
		}
		return null;
	}

	public Appversion findById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<Appversion> findAll() {
		return mapper.selectByExample(null);
	}

	public AppversionMapper getMapper() {
		return mapper;
	}

	public void setMapper(AppversionMapper mapper) {
		this.mapper = mapper;
	}

	
}
