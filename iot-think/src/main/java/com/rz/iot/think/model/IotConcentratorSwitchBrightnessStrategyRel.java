package com.rz.iot.think.model;

import java.util.Date;

public class IotConcentratorSwitchBrightnessStrategyRel {
    private Integer id;

    private Integer switchId;

    private Integer brightnessId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSwitchId() {
        return switchId;
    }

    public void setSwitchId(Integer switchId) {
        this.switchId = switchId;
    }

    public Integer getBrightnessId() {
        return brightnessId;
    }

    public void setBrightnessId(Integer brightnessId) {
        this.brightnessId = brightnessId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}