package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ray.dao.ResDao;
import com.ray.entity.Res;
import com.ray.entity.mapper.DynamicSql;
import com.ray.entity.mapper.ResMapper;
/**
 * 来源网站数据库操作实现接口
 * @author Ray
 * @date 2015年5月15日17:37:36
 */
@Service("ResDaoImpl")
public class ResDaoImpl implements ResDao {

	@Autowired
	private ResMapper mapper;
	
	public boolean addRes(Res res) {
		try {
			mapper.insert(res);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	public int getCount() {
		
		return mapper.countByExample(null);
	}



	public void deleteById(int id) {
		mapper.deleteByPrimaryKey(id);
	}



	public void update(Res res) {
		mapper.updateByPrimaryKey(res);
	}



	public List<Res> findByPage(int page, int pageSize) {
		String sql = "select id, name, url from res limit "+(page - 1) * pageSize+","+pageSize;
		new DynamicSql().setSql(sql);
		return mapper.selectByPage();
	}



	public List<Res> findAll() {
		return mapper.selectByExample(null);
	}


	@Transactional
	public void deleteByIds(String ids) {
		String[] idsStr = ids.split(",");
		for(String id : idsStr){
			mapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
	}



	public Res findById(int id) {
		return mapper.selectByPrimaryKey(id);
	}



	public ResMapper getMapper() {
		return mapper;
	}

	public void setMapper(ResMapper mapper) {
		this.mapper = mapper;
	}

	

	
}
