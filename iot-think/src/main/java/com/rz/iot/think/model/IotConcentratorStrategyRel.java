package com.rz.iot.think.model;

import java.util.Date;

/**
 * 开关策略与集中器的关系
 */
public class IotConcentratorStrategyRel {
    private Integer id;

    private Integer concentratorId;

    private String concentratorType;

    private Integer strategyId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConcentratorId() {
        return concentratorId;
    }

    public void setConcentratorId(Integer concentratorId) {
        this.concentratorId = concentratorId;
    }

    public String getConcentratorType() {
        return concentratorType;
    }

    public void setConcentratorType(String concentratorType) {
        this.concentratorType = concentratorType == null ? null : concentratorType.trim();
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
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