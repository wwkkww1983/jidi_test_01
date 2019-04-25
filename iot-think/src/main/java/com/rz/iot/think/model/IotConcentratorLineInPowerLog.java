package com.rz.iot.think.model;

import java.util.Date;

public class IotConcentratorLineInPowerLog {
    private Integer id;

    private Integer lineInId;

    private Integer voltage;

    private Integer electricCurrent;

    private Integer remainCurrent;

    private Integer powerFactor;

    private Integer apparentPower;

    private Integer activePower;

    private Integer lineFrequency;

    private Integer reactivePower;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLineInId() {
        return lineInId;
    }

    public void setLineInId(Integer lineInId) {
        this.lineInId = lineInId;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getElectricCurrent() {
        return electricCurrent;
    }

    public void setElectricCurrent(Integer electricCurrent) {
        this.electricCurrent = electricCurrent;
    }

    public Integer getRemainCurrent() {
        return remainCurrent;
    }

    public void setRemainCurrent(Integer remainCurrent) {
        this.remainCurrent = remainCurrent;
    }

    public Integer getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(Integer powerFactor) {
        this.powerFactor = powerFactor;
    }

    public Integer getApparentPower() {
        return apparentPower;
    }

    public void setApparentPower(Integer apparentPower) {
        this.apparentPower = apparentPower;
    }

    public Integer getActivePower() {
        return activePower;
    }

    public void setActivePower(Integer activePower) {
        this.activePower = activePower;
    }

    public Integer getLineFrequency() {
        return lineFrequency;
    }

    public void setLineFrequency(Integer lineFrequency) {
        this.lineFrequency = lineFrequency;
    }

    public Integer getReactivePower() {
        return reactivePower;
    }

    public void setReactivePower(Integer reactivePower) {
        this.reactivePower = reactivePower;
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