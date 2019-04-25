package com.rz.iot.think.model.param;

import java.util.Date;

/**
 * @Author:jidi
 * @Date:2019/04/10 11:50
 * @Description:查询报警箱基本信息
 **/
public class IotAlarmBoxSelectParam {
    //id
    private Integer id;

    //报警箱名称
    private String name;

    //报警箱唯一sn
    private String sn;

    //灯杆名称
    private String streetlightName;

    //设备型号
    private String modelNumber;

    //运行状态
    private Integer status;

    //厂商
    private String manufacturer;

    //更新时间
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

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber == null ? null : modelNumber.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStreetlightName() {
        return streetlightName;
    }

    public void setStreetlightName(String streetlightName) {
        this.streetlightName = streetlightName;
    }
}
