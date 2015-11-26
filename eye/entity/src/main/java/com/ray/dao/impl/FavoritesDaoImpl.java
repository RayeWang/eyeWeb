package com.ray.dao.impl;

import java.util.List;

import org.apache.ibatis.builder.xml.dynamic.DynamicSqlSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.FavoritesDao;
import com.ray.entity.Favorites;
import com.ray.entity.FavoritesCriteria;
import com.ray.entity.mapper.DynamicSql;
import com.ray.entity.mapper.FavoritesMapper;
/**
 * 收藏相关数据库操作接口实现类
 * @author Raye
 * @date 2015年11月26日13:45:27
 * 
 */
@Service
public class FavoritesDaoImpl implements FavoritesDao {

	@Autowired
	private FavoritesMapper mapper;
	
	public void addFavorite(String openid, String url) {
		mapper.insertFavorites(openid, url);
	}

	public void deleteFavorite(int id,String openid) {
		FavoritesCriteria criteria = new FavoritesCriteria();
		criteria.createCriteria().andIdEqualTo(id).andOpenidEqualTo(openid);
		mapper.deleteByExample(criteria);
	}
	


	public int getCount(String openid) {
		FavoritesCriteria criteria = new FavoritesCriteria();
		criteria.createCriteria().andOpenidEqualTo(openid);
		return mapper.countByExample(criteria);
	}

	public List<Favorites> findFavorites(int page, int rows,String openid) {
		String sql = "SELECT F.ID,A.TITLE,A.DESC1,A.URL,A.IMG,A.PARAM1"
				+ " FROM FAVORITES F LEFT JOIN ALERT A ON F.ARTICLEID=A.ID "
				+ " WHERE A.OPENID='"+openid+
				"' ORDER BY CREATETIME DESC LIMIT "+
				(page - 1)*rows+","+rows;
		new DynamicSql().setSql(sql);
		return mapper.findByDynamic();
	}

}
