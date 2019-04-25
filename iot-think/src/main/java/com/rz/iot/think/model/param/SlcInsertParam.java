package com.rz.iot.think.model.param;

/**
 * 描述:
 * 单灯控制器新增或修改的参数
 *
 * @author Zhouyz
 * @create 2019-04-09 10:28
 */

public class SlcInsertParam {
    //单灯控制器id
    private Integer id;
    //单灯控制器sn
    private String sn;
    //集中器id
    private Integer concentratorId;
    //单灯控制器名称
    private String name;
    //单灯控制器关联路灯id
    private String streetlightId;
    //单灯控制器状态
    private Integer status;
    //单灯控制器开关状态
    private Integer switchStatus;
    //单灯控制器亮度
    private Integer brightness;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getConcentratorId() {
        return concentratorId;
    }

    public void setConcentratorId(Integer concentratorId) {
        this.concentratorId = concentratorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetlightId() {
        return streetlightId;
    }

    public void setStreetlightId(String streetlightId) {
        this.streetlightId = streetlightId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Integer getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(Integer switchStatus) {
        this.switchStatus = switchStatus;
    }
}
