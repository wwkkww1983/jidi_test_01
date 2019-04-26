package com.rz.iot.think.mqtt.model.publish;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：服务端告警参数下发
 */
@Data
public class ConcentratorWarnConfigPublish {

    // // 控制类型 1：进线；2：输出 3：单灯控制器
    private int type;
    // 进线、输出、单灯控制器编号（第几进线、第几输出、第几单灯控制器）
    private int no;
    /**
     * 对于进线、回路:
     * 1: 电流上限告警
     * 2：电流上限保护
     * 3：电压上限告警
     * 4：电压上限保护
     * 5：电压下限告警
     * 6：电压下限保护
     * 7：温度上限告警
     * 8：温度上限保护
     *
     * 对于单灯控制器：
     * 0：不设置单灯控制器阈值
     * 1：设置单灯控制器阈值
     */
    private int nc;
    // 报警阈值值
    private int value = 0;
}
