package com.rz.iot.think.websocket;

import com.rz.iot.think.websocket.screen.ScreenWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/3/8.
 * PS: Not easy to write code, please indicate.
 * Description：
 */

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Resource
    private ScreenWebSocketHandler screenWebSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        //handler是webSocket的核心，配置入口
        webSocketHandlerRegistry.addHandler(
                new ProgressWebSocketHandler(),
                "/getProgress").setAllowedOrigins("*").addInterceptors(new SpringWebSocketHandlerInterceptor());
        webSocketHandlerRegistry.addHandler(
                screenWebSocketHandler,
                "/websocket/screenWebsocket").setAllowedOrigins("*");

    }

    // 设置websocket消息缓存大小
    @Bean
    public ServletServerContainerFactoryBean createServletServerContainerFactoryBean() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(3276800);
        container.setMaxBinaryMessageBufferSize(3276800);
        return container;
    }
}
