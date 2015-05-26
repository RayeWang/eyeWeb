package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.TypeDao;
import com.ray.entity.AlertType;
import com.ray.entity.mapper.AlertTypeMapper;
import com.ray.entity.mapper.DynamicSql;
/**
 * 文章类型的数据库操作接口实现类
 * @author Ray Wang
 * @date 2015年5月19日20:54:21
 * @version 1.0
 */
@Service
public class TypeDaoImpl implements TypeDao {

	@Autowired
	private AlertTypeMapper mapper;
	
	public boolean addType(AlertType type) {
		try {
			mapper.insert(type);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	public List<AlertType> findByPage(int page, int pageSize) {
		String sql = "select id, name, param1, param2 from alerttype"
				+ " limit "+(page - 1)*pageSize+","+pageSize;
		new DynamicSql().setSql(sql);
		return mapper.selectByDynamicSQL();
	}



	public int getCount() {
		return mapper.countByExample(null);
	}



	public void update(AlertType type) {
		mapper.updateByPrimaryKey(type);
	}



	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}



	public List<AlertType> findAll() {
		return mapper.selectByExample(null);
	}

	public AlertTypeMapper getMapper() {
		return mapper;
	}

	public void setMapper(AlertTypeMapper mapper) {
		this.mapper = mapper;
	}

}
