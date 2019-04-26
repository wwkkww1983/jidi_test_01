package com.rz.iot.think.model.show;

/**
 * Author by xuxiake, Date on 2019/4/2.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public class IotSingleLightControllerShowForStreetLightDetail {

    private Integer id;

    private String sn;

    private Integer concentratorId;

    private String name;

    private Integer status;

    private Integer switchStatus;

    private Integer brightness;

    private Integer ledLightsId;

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

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Integer getLedLightsId() {
        return ledLightsId;
    }

    public void setLedLightsId(Integer ledLightsId) {
        this.ledLightsId = ledLightsId;
    }
}
