package com.rz.iot.think.mqtt.model.publish;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：服务端输出控制命令下发
 */
@Data
public class ConcentratorCtrlCmdPublish {

    // 控制类型 1：单灯控制器；3：输出
    private int type;
    // 单灯控制器、编号（第几单灯控制器、第几输出）
    private int no;
    // 无意义（默认0）
    private int nc = 0;
    // 开关状态 0：断开（关）；1：闭合（开）
    private int value;
}
