package com.rz.iot.think.mqtt.model.report;

import com.rz.iot.utils.RzIotDigit;
import lombok.Data;

/**
 * @Author:jidi
 * @Date:2019/04/16 11:26
 * @Description:集中器环境参数上报
 **/
@Data
public class ConcenterEnvironmentParameterReport {
    //环境噪音值
    private int noise;
    //空气温度值
    private int temperature;
    //空气湿度
    private int humidity;
    //光照值
    private int illuminance;
    //大气压值
    private int barometricPressure;
    //风速
    private int windSpeed;
    /**
     * 风向
     * 0x0001=正北，0x0002=东北偏北，
     * 0x0004=正东北，0x0008=东北偏东，
     * 0x0010=正东，0x0020=东南偏东，
     * 0x0040=正东南，0x0080=东南偏南，
     * 0x0100=正南，0x0200=西南偏南，
     * 0x0400=正西南，0x0800=西南偏西，
     * 0x1000=正西，0x2000=西北偏西，
     * 0x4000=正西北，0x8000=西北偏北
     */
    private int windDirection;
    /**
     * 雨雪
     * 0x0000=无雨雪，0xAAAA=有雨雪
     */
    private int sleet;


    /**
     * 数据处理
     * @param data 原始消息报文
     * @param offset 消息头heard长度
     * @param length 数据长度
     */
    public void setParam(byte[] data, int offset, int length)  {
        this.noise = RzIotDigit.getUnInt16(data, offset);
        this.temperature = RzIotDigit.getUnInt16(data,offset+2);
        this.humidity = RzIotDigit.getUnInt16(data,offset+4);
        this.illuminance = RzIotDigit.getUnInt16(data,offset+6);
        this.barometricPressure = RzIotDigit.getUnInt16(data,offset+14);
        this.windSpeed = RzIotDigit.getUnInt16(data,offset+16);
        this.windDirection = RzIotDigit.getUnInt16(data,offset+18);
        this.sleet = RzIotDigit.getUnInt16(data, offset+20);
    }
}
