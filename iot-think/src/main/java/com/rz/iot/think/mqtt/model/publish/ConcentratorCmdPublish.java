package com.rz.iot.think.mqtt.model.publish;

import lombok.Data;

/**
 * @Author:jidi
 * @Date:2019/04/19 10:10
 * @Description:服务端控制命令下发
 **/
@Data
public class ConcentratorCmdPublish {
    /**
     * 服务端控制命令类型
     * 0x01：请求告警参数
     * 0x02：请求配置参数
     * 0x03：请求集中器时间
     * 0x04：请求时段预约方案
     * 0x05：请求星期预约方案
     * 0x06：请求当前电量
     * 0x07：清除电量
     * 0x11：集中器停止控制
     * 0x12：集中器启动
     * 0x13：停止当天预约
     * 0x14：恢复当天预约
     */
    private int type;

}
