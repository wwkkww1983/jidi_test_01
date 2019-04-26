package com.rz.iot.think.model.show;

/**
 * 描述:
 * 摄像头详细信息
 *
 * @author Zhouyz
 * @create 2019-04-08 9:21
 */

public class MonitorDetail {

    //摄像头名称
    private String monitorName;
    //摄像头sn
    private String monitorSn;
    //区名
    private String districtName;
    //摄像头ip
    private String monitorIp;
    //路名
    private String roadName;
    //摄像头版本
    private String version;
    //摄像头网络模式
    private Integer netType;
    //摄像头型号
    private String modelNumber;
    //路灯名
    private String streetlightName;
    //摄像头状态
    private Integer monitorStatus;
    //经度
    private Double lng;
    //纬度
    private Double lat;
    //安装高度
    private Float installPlace;
    //厂商名称
    private String manufacturer;

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public String getMonitorSn() {
        return monitorSn;
    }

    public void setMonitorSn(String monitorSn) {
        this.monitorSn = monitorSn;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getStreetlightName() {
        return streetlightName;
    }

    public void setStreetlightName(String streetlightName) {
        this.streetlightName = streetlightName;
    }

    public Integer getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(Integer monitorStatus) {
        this.monitorStatus = monitorStatus;
    }

    public Float getInstallPlace() {
        return installPlace;
    }

    public void setInstallPlace(Float installPlace) {
        this.installPlace = installPlace;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMonitorIp() {
        return monitorIp;
    }

    public void setMonitorIp(String monitorIp) {
        this.monitorIp = monitorIp;
    }

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
