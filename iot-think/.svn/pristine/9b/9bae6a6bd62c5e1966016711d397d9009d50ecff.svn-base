package com.rz.iot.think.websocket.screen;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author by xuxiake, Date on 2019/3/26.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Log4j2
@Component
public class ScreenWebSocketHandler extends AbstractWebSocketHandler {

    //websocket连接
    public static volatile Map<String, WebSocketSession> socketSessionMap = new ConcurrentHashMap();

    //消息接口同步返回
    public static volatile Map<String, String> resultMap = new ConcurrentHashMap();

    //每条消息一个计数器（使用计数器使发送与接收的异步变同步）
    public static volatile Map<String, CountDownLatch> cdlMap = new ConcurrentHashMap();

    //计数器超时设置
    public static Integer CDLTIME = 8000;

    @Resource
    private ScreenSendHandler screenSendHandler;

    // 握手实现连接后
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {

        String sessionId = session.getId();
        log.debug("有新的webSocket连接，sessionId为：{}", sessionId);
    }

    // 处理屏幕发来的文字消息
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {

        String payload = message.getPayload();
        // 可以在session中储存一些自定义属性
        Map<String, Object> attributes = session.getAttributes();
        log.debug("收到消息{}", payload);

        Map map = JSONObject.parseObject(payload, Map.class);

        // 发送给屏幕的消息每条都有唯一的编码id，屏幕会将这个id返回
        String _id = (String) map.get("_id");
        if (!StringUtils.isEmpty(_id)) {
            resultMap.put(_id, payload);
            CountDownLatch countDownLatch = cdlMap.remove(_id);
            // 计数器减1，发送消息的线程将会释放
            countDownLatch.countDown();
        }

        String cardId = (String) map.get("cardId");
        if(!StringUtils.isEmpty(cardId)) {
            log.debug("屏幕已连接，cardId为：{}", cardId);
            attributes.put("cardId", cardId);
            WebSocketSession last = socketSessionMap.put(cardId, session);
            if (last == null) {
                log.info("有新连接加入！当前在线显示屏：{}", socketSessionMap.size());
                screenSendHandler.connScreen(cardId);
            }
        }
    }

    /**
     * 向屏幕发送消息
     * @param cardId 卡id
     * @param message String型消息
     * @return
     */
    public static String sendMessage(String cardId, Object message) {

        return sendMessage(cardId, JSONObject.toJSONString(message).replace("\\/", "/"));
    }

    /**
     * 向屏幕发送消息
     * @param cardId 卡id
     * @param message 对象型消息
     * @return
     */
    public static String sendMessage(String cardId, String message) {

        Map map = JSONObject.parseObject(message, Map.class);
        String _id = (String) map.get("_id");

        if (!StringUtils.isEmpty(cardId)) {
            WebSocketSession session = socketSessionMap.get(cardId);
            if (session != null) {
                synchronized (session) {
                    if (session != null) {
                        try {
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            session.sendMessage(new TextMessage(message));
                            log.debug("发送成功消息：{}", message);
                            cdlMap.put(_id, countDownLatch);
                            // 使用计数器将线程阻塞
                            countDownLatch.await(CDLTIME, TimeUnit.MILLISECONDS);
                        } catch (IOException e) {
                            log.error(e.getMessage(), e);
                            log.error("消息发送失败，cardI：{}", cardId);
                        } catch (InterruptedException e) {
                            log.error(e.getMessage(), e);
                            log.error("信息屏计时器错误！");
                        }
                        return resultMap.remove(_id);
                    }
                }
            }
        }
        return null;
    }

    // 在连接关闭之后
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String cardId = (String) session.getAttributes().get("cardId");
        log.debug("屏幕连接已断开，cardId为：{}", cardId);
        if (socketSessionMap.get(cardId) != null) {
            socketSessionMap.remove(cardId);
        }
    }
}
