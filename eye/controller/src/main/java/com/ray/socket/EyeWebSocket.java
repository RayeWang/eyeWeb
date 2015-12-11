package com.ray.socket;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.ray.dao.MessageDao;
import com.ray.dao.impl.MessageDaoImpl;
import com.ray.entity.Appusers;
import com.ray.entity.Message;

/**
 * 聊天的webSocket
 * 协议openid:xxxxxx  用户登陆并开始获取消息 xxxxx是用户的openid
 * msg:{xxxxx} 发送消息，后面是消息具体内容json
 * @author Raye
 * 
 */
@ServerEndpoint("/talksocket")
public class EyeWebSocket {
	private static ConcurrentHashMap<String, Async> sessions = new ConcurrentHashMap<String, Async>();
	private static ConcurrentHashMap<Session, String> openids = new ConcurrentHashMap<Session, String>();
	
	@Autowired
	private MessageDao dao;
	
	@Bean
	public MessageDao getMessageDao(){
		return new MessageDaoImpl();
	}
	{
		dao = getMessageDao();
	}
	@OnMessage
	public void onMessage(String message, Session session){
		if(message.indexOf("openid:") == 0){
			String openid = message.substring(7);
			openids.put(session,openid);
			sessions.put(openid, session.getAsyncRemote());
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		if(dao == null){
			System.out.println("dao is null");
		}else{
			List<Message> messages = dao.selectByNoRead("DBE21903EC14D5E89A4DB60D9F6FBF70");
			session.getAsyncRemote().sendText("message size :" +messages.size());
		}
	}
	
	@OnClose
	public void onClose(Session session){
		if(sessions.containsKey(session)){
			sessions.remove(openids.get(session));
			openids.remove(session);
		}
	}

	public MessageDao getDao() {
		return dao;
	}

	public void setDao(MessageDao dao) {
		this.dao = dao;
	}
	
	
	
	
}
