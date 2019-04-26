package com.rz.iot.think.model.param;

import com.rz.iot.think.model.IotScreen;

/**
 * 描述:
 * 更新显示屏信息的参数实体
 *
 * @author Zhouyz
 * @create 2019-04-01 10:05
 */

public class ScreenUpdateParam {
    //显示屏实体
    private IotScreen screen;
    //亮度
    private Integer brightness;
    //音量
    private Integer volume;

    public IotScreen getScreen() {
        return screen;
    }

    public void setScreen(IotScreen screen) {
        this.screen = screen;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
