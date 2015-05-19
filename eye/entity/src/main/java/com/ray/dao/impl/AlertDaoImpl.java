package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.AlertDao;
import com.ray.entity.Alert;
import com.ray.entity.AlertCriteria;
import com.ray.entity.mapper.AlertMapper;
import com.ray.entity.mapper.DynamicSql;
/**
 * 文章数据库操作的相关接口实现
 * @author Ray Wang
 * @date 2015年5月16日21:21:30
 * @version 1.0
 */
@Service("alertDaoImpl")
public class AlertDaoImpl implements AlertDao {
	
	@Autowired
	private AlertMapper mapper;

	
	public boolean add(List<Alert> list) {
		try {
			for(Alert alert : list){
				mapper.insert(alert);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Alert> findByAlert(int page,int pageSize) {
		
		String sql = "select id,title,desc1,url from alert limit "+(page - 1)*pageSize+","+pageSize;
		
		new DynamicSql().setSql(sql);
		
		return mapper.selectByExamplePage();
	}

	
	public Alert findById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	public AlertMapper getMapper() {
		return mapper;
	}

	public void setMapper(AlertMapper mapper) {
		this.mapper = mapper;
	}

	
	
}
