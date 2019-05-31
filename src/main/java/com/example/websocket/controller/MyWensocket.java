package com.example.websocket.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Create by leinuo on 19-5-31 上午10:12
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
@ServerEndpoint(value = "/websocket")
@Component
public class MyWensocket {

    private static CopyOnWriteArraySet<MyWensocket>  webSockets=  new CopyOnWriteArraySet();

    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
       System.out.println("有新链接加入！");
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        System.out.println("有链接关闭！");
    }

    @OnMessage
    public void onMessage(String message,Session session) throws Exception{
        System.out.println("客户端有新消息！"+message+",session:"+session.getBasicRemote().toString());
        sendMessage("服务器端收到消息！");
    }


    public void sendMessage (String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
