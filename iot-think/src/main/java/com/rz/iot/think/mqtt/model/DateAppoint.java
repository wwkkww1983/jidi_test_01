package com.rz.iot.think.mqtt.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author:jidi
 * @Date:2019/04/16 9:06
 * @Description:日期预约方案
 **/
@Data
public class DateAppoint {
    //方案名
    private String name;
    //起始时间
    private Date startDate;
    //结束时间
    private Date endDate;
    //开灯时间
    private Date startTime;
    //关灯时间
    private Date endTime;
    //调光时间开
    private Date beginMoveLightTime;
    //调光时间关
    private Date endMoveLightTime;
    //调光百分比
    private int moveLightPercent;
    //隔杆模式
    private int intervalType;
    //开关标记
    private int switchTag;

}
