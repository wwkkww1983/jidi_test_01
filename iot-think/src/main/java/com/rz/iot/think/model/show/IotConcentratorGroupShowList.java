package com.rz.iot.think.model.show;

import java.util.Date;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 * Description：集中器组列表
 */
public class IotConcentratorGroupShowList {

    // 集中器组id
    private Integer id;
    // 集中器组名称
    private String name;
    // 集中器组编号
    private String sn;
    // 集中器状态 0：未激活； 1:正常运行；2：离线；3：故障； 9:已被删除;
    private Integer status;
    // 开关状态，1：开；0：关
    private Integer switchStatus;
    // 省
    private Long provinceId;
    private String provinceName;
    // 市
    private Long cityId;
    private String cityName;
    // 区
    private Long districtId;
    private String districtName;
    // 路
    private Integer roadId;
    private String roadName;
    // 策略模式：1：预约模式；2：经纬度开关；3：光感自动调光开关
    private Integer strategyMode;
    // 周期模式：1：日期；2：星期
    private Integer cycleMode;
    // 开始日期
    private Date startDate;
    // 结束日期
    private Date endDate;
    // 星期
    private String week;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 集中器列表
    private List<IotConcentratorShowList> concentrators;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(Integer switchStatus) {
        this.switchStatus = switchStatus;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getRoadId() {
        return roadId;
    }

    public void setRoadId(Integer roadId) {
        this.roadId = roadId;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
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
        this.week = week;
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

    public List<IotConcentratorShowList> getConcentrators() {
        return concentrators;
    }

    public void setConcentrators(List<IotConcentratorShowList> concentrators) {
        this.concentrators = concentrators;
    }
}
