package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ray.dao.AlertDao;
import com.ray.entity.Alert;
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

	@Transactional
	public void add(List<Alert> list) {
		if(list != null && list.size() > 0){
			for(int i = list.size() - 1;i > -1 ;i--){
				mapper.insertByProcedure(list.get(i));
			}
		}
	}

	public List<Alert> findByAlert(int page,int pageSize,int typeid,String key) {
		
		String sql = "select a.id,a.title,a.desc1,a.url,r.name as name,a.img,r.url as url1"
				+ " from alert a left join res r "
				+ " on a.res_id=r.id where a.title like #{key,jdbcType=VARCHAR}";
		if(typeid != 0){
			sql += " and atype_id=#{type,jdbcType=INTEGER}";
		}
		sql += " order by id desc limit "+
				(page - 1)*pageSize+","+pageSize;
		
		new DynamicSql().setSql(sql);
		
//		if(key.contains("%") || key.contains("_") || key.contains("'")){  
//			key = key.replaceAll("\\\\", "\\\\\\\\")  
//                             .replaceAll("\\%", "\\\\%")  
//                             .replaceAll("\\_", "\\\\_")
//                             .replace("\'", "\\'");
//        } 
		return mapper.selectByExamplePage("%"+key+"%",typeid);
	}

	
	
	public int findCount(int typeid, String key) {
		String sql = "select count(*) from alert where title like #{key,jdbcType=VARCHAR}";
		if(typeid != 0){
			sql += " and atype_id="+typeid;
		}
		new DynamicSql().setSql(sql);
		
		return mapper.countByDynamicSQL("%"+key+"%");
	}
	
	

	public void insertByPro(Alert alert) {
		mapper.insertByProcedure(alert);
	}

	@Transactional
	public void deleteByIds(String ids) {
		String[] temps = ids.split(",");
		for(String id:temps){
			if(id.isEmpty())
				continue;
			mapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
	}

	public void add(Alert alert) {
		mapper.insert(alert);
	}

	public void update(Alert alert) {
		mapper.update(alert);
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
