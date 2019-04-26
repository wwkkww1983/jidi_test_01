package com.rz.iot.think.model;

import java.util.Date;

/**
 * 开关策略
 */
public class IotConcentratorSwitchStrategy {
    private Integer id;

    private String name;

    private Integer strategyMode;

    private Integer cycleMode;

    private Integer offset;

    private Date startDate;

    private Date endDate;

    private String week;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private Date endTime;

    private Integer intervalType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStrategyMode() {
        return strategyMode;
    }

    public void setStrategyMode(Integer strategyMode) {
        this.strategyMode = strategyMode;
    }

    public Integer getCycleMode() {
        return cycleMode;
    }

    public void setCycleMode(Integer cycleMode) {
        this.cycleMode = cycleMode;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIntervalType() {
        return intervalType;
    }

    public void setIntervalType(Integer intervalType) {
        this.intervalType = intervalType;
    }
}