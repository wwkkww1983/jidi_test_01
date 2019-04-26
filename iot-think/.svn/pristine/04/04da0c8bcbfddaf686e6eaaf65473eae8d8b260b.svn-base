package com.rz.iot.think.mqtt.model.report;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/12.
 * PS: Not easy to write code, please indicate.
 * Description：集中器输出状态上报
 */
@Data
public class ConcentratorLineOutReport {

    // 来源 2：回路；3：输出；4：输入信号；1：单灯控制器
    private Integer source;
    // 编号（对应第几输出、第几单灯控制器）
    private Integer number;
    // 开关状态 0：断开（关）；1：闭合（开）
    private Integer status;

    public ConcentratorLineOutReport(Integer source, Integer number, Integer status) {
        this.source = source;
        this.number = number;
        this.status = status;
    }

    public ConcentratorLineOutReport() {

    }
}
