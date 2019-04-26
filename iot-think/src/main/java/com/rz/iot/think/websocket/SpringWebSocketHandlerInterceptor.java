package com.rz.iot.think.websocket;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用于websocket的拦截器
 */
@Log4j2
public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {
    /**
     * 在连接建立之前
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.debug("Before Handshake");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(true);
            if (session != null) {
                //使用sessionId区分WebSocketHandler，以便定向发送消息
                String sessionId = session.getId();
                if (sessionId != null && !"".equals(sessionId)) {
                    //确保一个用户一次只能建立一个连接
                    if (ProgressWebSocketHandler.userWebSocketSessionMap.get(sessionId) == null){
                        attributes.put("sessionId", sessionId);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
