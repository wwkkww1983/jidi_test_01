package com.rz.iot.think.model.show;

import lombok.Data;

@Data
public class IotStreetlightLedLightsShowDetail {

    // led Id
    private Integer id;
    // led名称
    private String name;
    // led sn
    private String sn;
    // led运行状态 1：正常
    private Integer status;
    // 灯具型号 1：雨雾灯；2：照明灯
    private Integer modelNumber;
    private Integer provinceId;
    private String provinceName;
    private Integer cityId;
    private String cityName;
    // 区
    private Integer districtId;
    private String districtName;
    // 路
    private Integer roadId;
    private String roadName;
    // 路灯名称
    private String streetLightName;
    // 安装位置 1：顶部；2：中左；3：中右
    private Integer installLocation;
    // 电压
    private Integer voltage;
    // 电流
    private Integer electricCurrent;
    // 额定功率
    private Integer ratedPower;
    // 灯具形状，1：球形灯
    private Integer lightType;
    // 光源型号，1：高压钠灯
    private Integer lightSource;
    // 生产厂商
    private String manufactor;
}
