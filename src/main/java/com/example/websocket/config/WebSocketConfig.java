package com.example.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * Create by leinuo on 19-5-31 上午9:59
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter ServerEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
