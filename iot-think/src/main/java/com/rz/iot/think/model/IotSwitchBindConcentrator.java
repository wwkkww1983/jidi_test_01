package com.rz.iot.think.model;

import java.util.List;

/**
 * Created by rycony on 2019/3/13 0013.
 *
 * 用于接收开关策略绑定集中器(组)
 */
public class IotSwitchBindConcentrator {
    //开关id
    private Integer switchId;
    //集中器(组)id
    private List<Integer> concentratorId;
    //类型
    private String concentratorType;
    //开关状态
    private Integer switchStatus;
    //亮度
    private Integer brightness;

    public Integer getSwitchId() {
        return switchId;
    }

    public void setSwitchId(Integer switchId) {
        this.switchId = switchId;
    }

    public List<Integer> getConcentratorId() {
        return concentratorId;
    }

    public void setConcentratorId(List<Integer> concentratorId) {
        this.concentratorId = concentratorId;
    }

    public String getConcentratorType() {
        return concentratorType;
    }

    public void setConcentratorType(String concentratorType) {
        this.concentratorType = concentratorType;
    }

    public Integer getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(Integer switchStatus) {
        this.switchStatus = switchStatus;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }
}
