package com.ray.dao;

import java.util.List;

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
	/**
	 * 查询所有分类来源
	 * @return 所有分类来源
	 */
	public List<ResLink> findAll();
	
	/**
	 * 获取总数量，用于分页
	 * @return 总数量
	 */
	public int getCount();
	
	/**
	 * 根据分页查询
	 * @param page 当前页的索引
	 * @param pageSize 每页显示的数量
	 * @return 分类来源集合
	 */
	public List<ResLink> findByPage(int page,int pageSize);
	
	/**
	 * 修改一个分类来源
	 * @param link 分类来源
	 */
	public void update(ResLink link);
	/**
	 * 删除一个分类来源
	 * @param id 来源id
	 */
	public void deleteById(int id);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public ResLink findById(int id);
}
