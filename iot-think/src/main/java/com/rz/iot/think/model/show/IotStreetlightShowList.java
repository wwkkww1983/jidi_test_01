package com.rz.iot.think.model.show;

import com.rz.iot.think.model.IotSingleLightController;
import com.rz.iot.think.model.IotStreetlightInstallDevRel;

import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/13.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public class IotStreetlightShowList {

    // 路灯id
    private Integer id;
    // 路灯名称
    private String name;
    // sn
    private String sn;
    // 路灯类型
    private Integer devType;
    // 路灯状态
    private Integer status;
    // 灯杆类型
    private Integer brandType;
    // 版本
    private String version;
    // 路灯亮度状态
    private Integer lightStatus;

    private Integer monitor;

    private Integer screen;

    private Integer wifi;

    private Integer environmentalSensor;

    private Integer emergencyCalling;

    private Integer chargingPoint;
    // 单灯控制器列表
    private List<IotSingleLightControllerShowForStreetLightDetail> singleLightControllers;

    public Integer getEmergencyCalling() {
        return emergencyCalling;
    }

    public void setEmergencyCalling(Integer emergencyCalling) {
        this.emergencyCalling = emergencyCalling;
    }

    public Integer getChargingPoint() {
        return chargingPoint;
    }

    public void setChargingPoint(Integer chargingPoint) {
        this.chargingPoint = chargingPoint;
    }

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    public Integer getScreen() {
        return screen;
    }

    public void setScreen(Integer screen) {
        this.screen = screen;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    public Integer getEnvironmentalSensor() {
        return environmentalSensor;
    }

    public void setEnvironmentalSensor(Integer environmentalSensor) {
        this.environmentalSensor = environmentalSensor;
    }

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
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(Integer lightStatus) {
        this.lightStatus = lightStatus;
    }

    public List<IotSingleLightControllerShowForStreetLightDetail> getSingleLightControllers() {
        return singleLightControllers;
    }

    public void setSingleLightControllers(List<IotSingleLightControllerShowForStreetLightDetail> singleLightControllers) {
        this.singleLightControllers = singleLightControllers;
    }
}
