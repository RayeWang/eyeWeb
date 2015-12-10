package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.APPUserDao;
import com.ray.entity.Appusers;
import com.ray.entity.AppusersCriteria;
import com.ray.entity.mapper.AppusersMapper;
import com.ray.entity.mapper.DynamicSql;

/**
 * APPUser相关数据库操作实现类
 * @author Raye
 *
 */
@Service
public class APPUserDaoImpl implements APPUserDao {
	
	@Autowired
	private AppusersMapper mapper;

	public void insert(Appusers appusers) {
		new DynamicSql().setSql("CALL `eyedata`.`create_user`(#{openid,jdbcType=VARCHAR},"
				+ "#{accesstoken,jdbcType=VARCHAR}, #{expiresin,jdbcType=VARCHAR});");
		mapper.insertByDynamic(appusers);
	}

	public Appusers selectByOpenid(String openid) {
		AppusersCriteria criteria = new AppusersCriteria();
		criteria.createCriteria().andOpenidEqualTo(openid);
		List<Appusers> list = mapper.selectByExample(criteria);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
