package com.rz.iot.think.mqtt.model.report;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/12.
 * PS: Not easy to write code, please indicate.
 * Description：集中器心跳上报
 */
@Data
public class ConcentratorHeartbeatReport {

    // 信号强度
    private int signalStrength;
}
