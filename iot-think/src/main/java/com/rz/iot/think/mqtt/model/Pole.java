package com.rz.iot.think.mqtt.model;

import lombok.Data;

/**
 * @Author:jidi
 * @Date:2019/04/17 9:19
 * @Description:隔杆模式灯具
 **/

@Data
public class Pole {
    //单灯控制器id
    private int id;
    //状态 0：灭；1：开
    private int status;
}
