package com.rz.iot.think.mqtt.model;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/12.
 * PS: Not easy to write code, please indicate.
 * Description：集中器输出
 */
@Data
public class ConcentratorLineOut {

    // 输出名称
    private String name;
    // 序号
    private Integer no;
    // 电流
    private Integer electricCurrent;
    // 有功功率
    private Integer activePower;
}
