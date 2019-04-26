package com.rz.iot.think.model.param;

import java.util.Date;

/**
 * @Author:jidi
 * @Date:2019/04/11 10:56
 * @Description:报警历史统计
 **/
public class IotAlarmBoxRecorderSelectParam {

    //报警箱id
    private Integer id;

    //报警信息记录id
    private Integer recordId;

    //报警箱名字
    private String name;

    //报警箱唯一sn码
    private String sn;

    //灯杆名称
    private String streetlightName;

    //省份名
    private String provinceName;

    //城市名
    private String cityName;

    //区名
    private  String districtName;

    //路名
    private String roadName;

    //报警时间
    private Date createTime;

    //接警时间
    private Date answerTime;

    //报警处理状态
    private Integer status;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }
}
