package com.rz.iot.think.model.show;

/**
 * 描述:
 * GIS地图信息页获取的路灯信息
 *
 * @author Zhouyz
 * @create 2019-03-16 17:35
 */

public class GISStreetlightShowList {
    //路灯id
    private Integer streetLightId;
    //经度
    private Integer lng;
    //纬度
    private Integer lat;
    //路灯开闭状态
    private Integer switchStatus;
    //区域关联表id
    private Integer areaRelId;
    //道路id
    private Integer roadId;
    //路灯状态 0：未激活；1：正常运行；2：离线；3：故障； 9：已被删除;
    private Integer streetlightStatus;
    //是否挂载了摄像头
    private Integer hasMonitor;

    public Integer getStreetLightId() {
        return streetLightId;
    }

    public void setStreetLightId(Integer streetLightId) {
        this.streetLightId = streetLightId;
    }

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(Integer switchStatus) {
        this.switchStatus = switchStatus;
    }

    public Integer getAreaRelId() {
        return areaRelId;
    }

    public void setAreaRelId(Integer areaRelId) {
        this.areaRelId = areaRelId;
    }

    public Integer getRoadId() {
        return roadId;
    }

    public void setRoadId(Integer roadId) {
        this.roadId = roadId;
    }

    public Integer getStreetlightStatus() {
        return streetlightStatus;
    }

    public void setStreetlightStatus(Integer streetlightStatus) {
        this.streetlightStatus = streetlightStatus;
    }

    public Integer getHasMonitor() {
        return hasMonitor;
    }

    public void setHasMonitor(Integer hasMonitor) {
        this.hasMonitor = hasMonitor;
    }
}
