package com.rz.iot.think.model.param;

import java.util.Date;

/**
 * @Author:jidi
 * @Date:2019/04/10 16:21
 * @Description:查询报警箱详细信息
 **/
public class IotAlarmBoxSelectDetailParam {
    //id
    private Integer id;

    //报警箱名字
    private String name;

    //报警箱唯一sn码
    private String sn;

    //灯杆名称
    private String streetlightName;

    //设备型号
    private String modelNumber;

    //运行状态
    private Integer status;

    //网络模式
    private Integer netType;

    //版本信息
    private String version;

    //省份名
    private String provinceName;

    //城市名
    private String cityName;

    //区名
    private  String districtName;

    //路名
    private String roadName;

    //ip
    private String ip;

    //厂商
    private String manufacturer;

    //挂载位置（高度）
    private Float installPlace;

    //更新时间
    private Date updateTime;

    //经度
    private Double lng;

    //纬度
    private Double lat;

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

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Float getInstallPlace() {
        return installPlace;
    }

    public void setInstallPlace(Float installPlace) {
        this.installPlace = installPlace;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getStreetlightName() {
        return streetlightName;
    }

    public void setStreetlightName(String streetlightName) {
        this.streetlightName = streetlightName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
}
