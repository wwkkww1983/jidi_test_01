package com.rz.iot.think.mqtt.model.publish;

import com.rz.iot.think.mqtt.model.ConcentratorSwitchStrategy;
import lombok.Data;

import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/16.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Data
public class ConcentratorSwitchStrategyPublish {

    // 策略模式 1：日期；2：星期；3：经纬度
    private Integer strategyType;
    // 集中器开关策略
    private List<ConcentratorSwitchStrategy> concentratorSwitchStrategies;
}
