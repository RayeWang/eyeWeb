package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.ResLinkDao;
import com.ray.entity.ResLink;
import com.ray.entity.mapper.DynamicSql;
import com.ray.entity.mapper.ResLinkMapper;
/**
 * 来源分类的数据库操作实现类
 * @author Ray Wang
 * @date 2015年5月19日20:36:54
 * @version 1.0
 */
@Service("resLinkDaoImpl")
public class ResLinkDaoImpl implements ResLinkDao {
	
	@Autowired
	private ResLinkMapper mapper;

	public boolean addLink(ResLink link) {
		try {
			mapper.insert(link);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	public List<ResLink> findAll() {
		String sql = "select r.id,r.name,r.url,r.resid,r.typeid,(select title"
				+ " from alert where res_link_id=r.id "+
				"order by id desc limit 0,1) as title from res_link r";
		DynamicSql dynameic = new DynamicSql();
		dynameic.setSql(sql);
		return mapper.selectAll();
	}



	public ResLinkMapper getMapper() {
		return mapper;
	}

	public void setMapper(ResLinkMapper mapper) {
		this.mapper = mapper;
	}

	
	
	
}