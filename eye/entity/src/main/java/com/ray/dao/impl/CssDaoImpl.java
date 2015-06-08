package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.CssDao;
import com.ray.entity.Css;
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

	public CssMapper getMapper() {
		return mapper;
	}

	public void setMapper(CssMapper mapper) {
		this.mapper = mapper;
	}

	
}
