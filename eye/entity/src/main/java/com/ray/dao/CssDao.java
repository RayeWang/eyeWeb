package com.ray.dao;

import java.util.List;

import com.ray.entity.Css;

/**
 * 样式的相关数据库操作
 * @author Ray Wang
 * @date 2015年6月7日11:02:48
 * @version 1.0
 */
public interface CssDao {

	/**
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Css> findByPage(int page,int rows);
	/**
	 * 根据分类来源ID查询
	 * @param id
	 * @return
	 */
	public List<Css> findByLinkId(int id);
	
	/**
	 * 更新一个样式id
	 * @param ids  需要添加或者更新的css的id（用<;>隔开的，如果小于0则是添加）
	 * @param values 具体内容（和ids一一对应，用<;>隔开）
	 * @param dels 需要删除的id集合（<;>隔开）
	 * @param linkid 分类来源的id
	 */
	public void update(String ids,String values,String dels,int linkid,String androids);
}
