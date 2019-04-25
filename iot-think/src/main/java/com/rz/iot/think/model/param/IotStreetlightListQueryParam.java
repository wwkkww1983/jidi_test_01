package com.rz.iot.think.model.param;

/**
 * Author by xuxiake, Date on 2019/3/13.
 * PS: Not easy to write code, please indicate.
 * Description：路灯列表查询参数
 */
public class IotStreetlightListQueryParam {

    // 街道id
    private Integer districtId;
    // 路id
    private Integer roadId;
    // 路灯名称
    private String name;
    // 灯杆类型 1：think；2：科幻
    private Integer brandType;
    // 路灯类型 1：普通路灯；2：智慧路灯
    private Integer devType;
    // 挂载设备类型 1：摄像头；2：显示屏；3：WiFi；4：环境传感器
    private Integer installDevType;

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getRoadId() {
        return roadId;
    }

    public void setRoadId(Integer roadId) {
        this.roadId = roadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public Integer getInstallDevType() {
        return installDevType;
    }

    public void setInstallDevType(Integer installDevType) {
        this.installDevType = installDevType;
    }
}
