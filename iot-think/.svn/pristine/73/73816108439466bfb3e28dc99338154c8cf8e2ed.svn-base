package com.rz.iot.think.mqtt.handler;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Author by xuxiake, Date on 2019/4/10.
 * PS: Not easy to write code, please indicate.
 * Description：mqtt发送消息网关
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {

    /**
     * 推送消息
     * @param data 数据
     * @param topic 主题
     */
    void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
