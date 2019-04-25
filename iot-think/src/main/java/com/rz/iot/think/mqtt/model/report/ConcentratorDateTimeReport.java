package com.rz.iot.think.mqtt.model.report;

import com.rz.iot.utils.RzIotDatetime;
import com.rz.iot.utils.RzIotDigit;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.util.Date;

/**
 * Author by xuxiake, Date on 2019/4/12.
 * PS: Not easy to write code, please indicate.
 * Description：集中器当前时间上报
 */
@Data
@Log4j2
public class ConcentratorDateTimeReport {

    // 秒
    private int second;
    // 分
    private int minute;
    // 时
    private int hour;
    // 星期
    private int week;
    // 日
    private int day;
    // 月
    private int month;
    // 年
    private int year;
    // 时间
    private Date date;

    /**
     * 数据处理
     * @param data 原始消息报文
     * @param offset 消息头heard长度
     * @param length 数据长度
     */
    public void setParam(byte[] data, int offset, int length) {

        this.second = RzIotDigit.getUnInt(data, offset);
        this.minute = RzIotDigit.getUnInt(data, offset + 1);
        this.hour = RzIotDigit.getUnInt(data, offset + 2);
        this.week = RzIotDigit.getUnInt(data, offset + 3);
        this.day = RzIotDigit.getUnInt(data, offset + 4);
        this.month = RzIotDigit.getUnInt(data, offset + 5);
        this.year = RzIotDigit.getUnInt(data, offset + 6) + 2000;

        try {
            this.date = RzIotDatetime.stringToDate(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
    }
}
