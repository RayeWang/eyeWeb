package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ray.dao.CssDao;
import com.ray.entity.Css;
import com.ray.entity.CssCriteria;
import com.ray.entity.mapper.CssMapper;
/**
 * 样式的数据库操作实现类
 * @author Ray Wang
 * @date 2015年6月7日11:22:24
 * @version 1.0
 */
@Service("cssDaoImpl")
public class CssDaoImpl implements CssDao {

	@Autowired
	private CssMapper mapper;
	
	public List<Css> findByPage(int page, int rows) {
		return mapper.seletdByPage((page - 1) * rows, rows);
	}

	public List<Css> findByLinkId(int id) {
		CssCriteria criteria = new CssCriteria();
		criteria.createCriteria().andResLinkIdEqualTo(id);
		return mapper.selectByExample(criteria);
	}

	@Transactional
	public void update(String ids, String values, String dels, int linkid) {
		String[] tempIds = ids.split("<;>");
		String[] tempValues = values.split("<;>");
		String[] tempDels = dels.split("<;>");
		//插入或更新
		if(tempIds != null && tempIds.length > 0 && tempValues != null && tempValues.length > 0){
			for(int i = 0;i < tempIds.length;i++){
				String tid = tempIds[i];
				if(tid.isEmpty()){
					continue;
				}
				int id = Integer.parseInt(tid);
				if(id > 0){
					//更新
					Css record = new Css();
					record.setResLinkId(linkid);
					record.setCsslink(tempValues[i]);
					record.setId(id);
					mapper.updateByPrimaryKey(record);
				}else{
					//插入
					Css record = new Css();
					record.setCsslink(tempValues[i]);
					record.setResLinkId(linkid);
					mapper.insert(record);
				}
			}
		}
		
		//删除
		if(tempDels != null && tempDels.length > 0){
			for(String id : tempDels){
				if(id.isEmpty()){
					continue;
				}
				mapper.deleteByPrimaryKey(Integer.parseInt(id));
			}
		}
	}

	public CssMapper getMapper() {
		return mapper;
	}

	public void setMapper(CssMapper mapper) {
		this.mapper = mapper;
	}

	
}
