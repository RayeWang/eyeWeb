package com.ray.dao;

import java.util.List;

import com.ray.entity.Alert;

/**
 * 文章相关操作的数据库接口
 * @author Ray Wang
 * @date 2015年5月16日21:08:03
 * @version 1.0
 * 
 * 查询添加了type字段和key关键字
 * @date 2015年5月23日23:35:47
 * @version 1.1
 */
public interface AlertDao {

	/**
	 * 添加文章
	 * @param list 列表
	 */
	public void add(List<Alert> list);
	
	/**
	 * 根据模板查询文章
	 * @param page 当前页的索引
	 * @param pageSize 每页显示的大小
	 * @param typeid 分类的id，0则查询所有'
	 * @param key 关键字（目前只是标题）
	 * @return 文章集合
	 */
	public List<Alert> findByAlert(int page,int pageSize,int typedid,String key);
	
	/**
	 * 根据ID查询文章
	 * @param id 文章的id
	 * @return
	 */
	public Alert findById(int id);
	
	/**
	 * 查询文章数量，用于分页
	 * @param typeid 分类的ID，0则查询所有
	 * @param key 关键字（目前只是标题）
	 * @return 总数量
	 */
	public int findCount(int typeid,String key);
	
	/**
	 * 根据id集合进行删除
	 * @param ids id集合
	 * @return
	 */
	public void deleteByIds(String ids);
	
	/**
	 * 更新一篇文章
	 * @param alert 文章对象
	 */
	public void update(Alert alert);
	/**
	 * 添加一篇文章
	 * @param alert
	 */
	public void add(Alert alert);
}
