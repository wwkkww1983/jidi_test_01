package com.rz.iot.think.model.show;

/**
 * 描述:
 * GIS地图页面集中器信息列表
 *
 * @author Zhouyz
 * @create 2019-03-19 9:18
 */

public class GISConcentratorList {
    //集中器名
    private String name;
    //集中器id
    private Integer id;
    //集中器纬度
    private Integer lat;
    //集中器经度
    private Integer lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }
}
