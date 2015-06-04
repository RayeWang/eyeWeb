package com.ray.dao;

import java.util.List;

import com.ray.entity.Res;


/**
 * 来源网站的相关数据数据库操作接口
 * @author Ray
 * @date 2015年5月15日17:24:39
 * @version 1.0
 */
public interface ResDao {

	/**
	 * 添加一个来源网站
	 * @param res 来源网站对象
	 * @return 时候添加成功
	 */
	public boolean addRes(Res res);
	
	/**
	 * 查询所有来源
	 * @return
	 */
	public List<Res> findAll();
	
	/**
	 * 获取所有数据量，用于分页
	 * @return
	 */
	public int getCount();
	
	/**
	 * 根据id来删除一个网站来源
	 * @param id
	 */
	public void deleteById(int id);
	/**
	 * 更新
	 * @param res
	 */
	public void update(Res res);
	
	/**
	 * 根据分页查询
	 * @param page 当前页面索引
	 * @param pageSize 每页显示的数据大小
	 * @return
	 */
	public List<Res> findByPage(int page,int pageSize);
	/**
	 * 根据id集合删除
	 * @param ids
	 */
	public void deleteByIds(String ids);
}
