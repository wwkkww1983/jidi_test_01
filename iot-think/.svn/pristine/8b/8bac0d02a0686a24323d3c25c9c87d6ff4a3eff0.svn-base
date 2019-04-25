package com.rz.iot.think.model;

import java.util.Date;

public class SysDeviceConnRecord {
    private Integer id;

    private Integer deviceId;

    private Integer deviceType;

    private Integer connType;

    private Date createTime;

    private Date updateTime;

    private String message;

    //     * 设备类型 1：摄像头；2：显示屏；3：WiFi；4：环境传感器
	//     * @param devid 设备id
	//     * @param devType 设备类型
	//     * @param connType 连接类型;1/连接 ；2/断开
	//     * @param message 消息内容
	//     */
    public SysDeviceConnRecord(Integer devid ,Integer devType , Integer connType ,String message ){
        this.deviceId = devid;
        this.deviceType = devType;
        this.message = message;
        this.connType = connType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getConnType() {
        return connType;
    }

    public void setConnType(Integer connType) {
        this.connType = connType;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}