package com.rz.iot.think.model;

import java.util.Date;

public class IotSingleLightControllerLedLightsRel {
    private Integer id;

    private Integer slcId;

    private Integer letLightsId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlcId() {
        return slcId;
    }

    public void setSlcId(Integer slcId) {
        this.slcId = slcId;
    }

    public Integer getLetLightsId() {
        return letLightsId;
    }

    public void setLetLightsId(Integer letLightsId) {
        this.letLightsId = letLightsId;
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