package com.rz.iot.think.model.screen;

import java.util.Date;

public class IotScreenPlayStrategyCommandRel {
    private Integer id;

    private Integer playStrategyId;

    private Integer screenId;

    private String commandNo;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayStrategyId() {
        return playStrategyId;
    }

    public void setPlayStrategyId(Integer playStrategyId) {
        this.playStrategyId = playStrategyId;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getCommandNo() {
        return commandNo;
    }

    public void setCommandNo(String commandNo) {
        this.commandNo = commandNo == null ? null : commandNo.trim();
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