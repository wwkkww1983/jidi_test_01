package com.rz.iot.think.model.param;

/**
 * 描述:
 * 摄像头查找参数
 *
 * @author Zhouyz
 * @create 2019-04-04 18:07
 */

public class MonitorSearchParam {
    //摄像头名称
    private String monitorName;
    //摄像头型号
    private String monitorModelName;
    //摄像头状态
    private String monitorStatus;
    //摄像头sn
    private String monitorSn;

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public String getMonitorModelName() {
        return monitorModelName;
    }

    public void setMonitorModelName(String monitorModelName) {
        this.monitorModelName = monitorModelName;
    }


    public String getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(String monitorStatus) {
        this.monitorStatus = monitorStatus;
    }
}
