package com.rz.iot.think.model;

import java.util.Date;

public class IotStreetlightLedLights {
    private Integer id;

    private String name;

    private String sn;

    private Integer modelNumber;

    private String describe;

    private Integer voltage;

    private Integer electricCurrent;

    private Integer installLocation;

    private Integer status;

    private Integer ratedPower;

    private Integer lightType;

    private Integer lightSource;

    private String manufactor;

    private Date createTime;

    private Date updateTime;

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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(Integer modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
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

    public Integer getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(Integer installLocation) {
        this.installLocation = installLocation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(Integer ratedPower) {
        this.ratedPower = ratedPower;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Integer getLightSource() {
        return lightSource;
    }

    public void setLightSource(Integer lightSource) {
        this.lightSource = lightSource;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor == null ? null : manufactor.trim();
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