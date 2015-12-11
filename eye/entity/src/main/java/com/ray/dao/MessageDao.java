package com.ray.dao;

import java.util.List;

import com.ray.entity.Message;

/**
 * 消息相关的数据库操作接口
 * @author Raye
 *
 */
public interface MessageDao {
	
	/**
	 * 插入消息
	 * @param message
	 */
	public void insert(Message message);
	/**
	 * 获取未读消息
	 * @param openid
	 * @return
	 */
	public List<Message> selectByNoRead(String openid);
	
	/**
	 * 删除消息
	 * @param openid
	 * @param id 当前客户端已经获取到的消息id
	 */
	public void deleteMsg(String openid,int id);
}
