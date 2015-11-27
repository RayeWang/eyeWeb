package com.ray.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hellsocket")
public class EyeWebSocket {
	
	@OnMessage
	public void onMessage(String message, Session session){
		System.out.println(message);
		try {
			while(true){
				session.getBasicRemote().sendText("nowTime:"+System.currentTimeMillis());
				Thread.sleep(5000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
	    System.out.println("Client connected"+session.getId());
	}
	
	@OnClose
	public void onClose(Session session){
		
	}
	
	
}
