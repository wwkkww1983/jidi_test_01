package com.rz.iot.think.mqtt.model.publish;

import lombok.Data;

import java.util.Date;

/**
 * @Author:jidi
 * @Date:2019/04/18 17:55
 * @Description:电量定时上报时间下发
 **/
@Data
public class ConcentratorElectricTimingReportTimePublish {

    //电量上报时间
    private Date reportDate;
}
