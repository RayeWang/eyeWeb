package com.ray.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.dao.MessageDao;
import com.ray.entity.Message;
import com.ray.entity.MessageCriteria;
import com.ray.entity.mapper.MessageMapper;

/**
 * 获取消息的相关数据库操作实现类
 * @author Raye
 * 
 */
@Service
public class MessageDaoImpl implements MessageDao {

	@Autowired
	private MessageMapper mapper;
	
	public void insert(Message message) {
		mapper.insert(message);
	}

	public List<Message> selectByNoRead(String openid) {
		MessageCriteria criteria = new MessageCriteria();
		criteria.createCriteria().andToopenidEqualTo(openid).
			andStateEqualTo(0);
		return mapper.selectByExample(criteria);
	}

	public void deleteMsg(String openid, int id) {
		MessageCriteria criteria = new MessageCriteria();
		criteria.createCriteria().andIdLessThan(id).
			andToopenidEqualTo(openid);
		mapper.deleteByExample(criteria);
	}

}
