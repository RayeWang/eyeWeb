package com.ray.dao;

import com.ray.entity.ResLink;

/**
 * 来源分类的数据库操作接口
 * @author Ray Wang
 * @date 2015年5月19日20:35:24
 * @version 1.0
 */
public interface ResLinkDao {

	/**
	 * 添加一个Link
	 * @param link 来源分类的对象
	 * @return
	 */
	public boolean addLink(ResLink link);
}
