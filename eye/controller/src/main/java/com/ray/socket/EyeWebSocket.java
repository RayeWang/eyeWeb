package com.ray.socket;

import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.SendResult;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.SendHandler;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.ray.dao.MessageDao;
import com.ray.entity.Message;

/**
 * 聊天的webSocket
 * 协议openid:xxxxxx  用户登陆并开始获取消息 xxxxx是用户的openid
 * msg:{xxxxx} 发送消息，后面是消息具体内容json   toopenid=0是聊天室消息
 * succuess:xxxx 返回客户端消息发送成功，后面xxx是消息id
 * @author Raye
 * 
 */
@ServerEndpoint("/talksocket")
public class EyeWebSocket {
	private static ConcurrentHashMap<String, Async> sessions = new ConcurrentHashMap<String, Async>();
	private static ConcurrentHashMap<Session, String> openids = new ConcurrentHashMap<Session, String>();
	private Gson gson;
	@Autowired
	private MessageDao dao;
	private SendHandler handler = new SendHandler() {
		
		public void onResult(SendResult result) {
			System.out.println(result.isOK());
		}
	};
	
	public EyeWebSocket(){
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
	  	dao = (MessageDao) context.getBean("messageDao");
	  	gson = new Gson();
	}
	@OnMessage
	public void onMessage(String message, Session session){
		System.out.println("size:"+sessions.size());
		if(message.indexOf("openid:") == 0){
			String openid = message.substring(7);
			openids.put(session,openid);
			sessions.put(openid, session.getAsyncRemote());
			List<Message> messages = dao.selectByNoRead(openid);
			if(messages.size() > 0){
				session.getAsyncRemote().sendText("msg:"+new Gson().toJson(messages), handler);
			}
		}else if(message.indexOf("msg:") == 0){
			try {
				String msg = message.substring(4);
				Message message2 = gson.fromJson(msg, Message.class);
				if(message2.getToopenid().equals("0")){
					//群消息

					for(Entry<String, Async> entry: sessions.entrySet()){
						if(!entry.getKey().equals(message2.getFromopenid())){
							entry.getValue().sendText(message);
						}
					}
				}else{

					dao.insert(message2);
					if(sessions.containsKey(message2.getToopenid())){
						//在线，发送消息过去
						List<Message> messages = dao.selectByNoRead(message2.getToopenid());
						sessions.get(message2.getToopenid()).sendText(message);
					}
				}

				session.getAsyncRemote().sendText("succuess:"+message2.getId());
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		
	}
	
	@OnClose
	public void onClose(Session session){
		if(sessions.containsKey(session)){
			System.out.println("onClose");
			sessions.remove(openids.get(session));
			openids.remove(session);
		}
	}

	
	
	
	
	
}
