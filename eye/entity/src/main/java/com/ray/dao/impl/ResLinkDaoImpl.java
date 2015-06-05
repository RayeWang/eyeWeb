package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



	public int getCount() {
		return mapper.countByExample(null);
	}



	public ResLink findById(int id) {
		return mapper.selectByPrimaryKey(id);
	}



	public List<ResLink> findByPage(int page, int pageSize) {
		String sql = "select id, name, url, resid, typeid from res_link "
				+ "limit "+(page - 1) * pageSize+","+pageSize;
		new DynamicSql().setSql(sql);
		
		return mapper.selectByPage();
	}



	@Transactional
	public void deleteByIds(String ids) {
		String[] idsStr = ids.split(",");
		for(String id : idsStr){
			mapper.deleteByPrimaryKey(Integer.parseInt(id));
		}

	}



	public void update(ResLink link) {
		mapper.updateByPrimaryKey(link);
	}



	public void deleteById(int id) {
		mapper.deleteByPrimaryKey(id);
	}



	public ResLinkMapper getMapper() {
		return mapper;
	}

	public void setMapper(ResLinkMapper mapper) {
		this.mapper = mapper;
	}

	
	
	
}
