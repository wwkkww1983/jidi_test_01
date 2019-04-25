package com.rz.iot.think.mqtt.model.report;

import com.rz.iot.utils.RzIotDatetime;
import com.rz.iot.utils.RzIotDigit;
import com.rz.iot.utils.RzIotString;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.util.Date;

/**
 * Author by xuxiake, Date on 2019/4/12.
 * PS: Not easy to write code, please indicate.
 * Description：集中器配置参数上报
 */
@Data
@Log4j2
public class ConcentratorConfigParamReport {

    // 区号
    private String districtNo;
    // 厂商编号
    private String manufacturerNo;
    // 序列号
    private String sn;
    // 相数
    private int phaseType;
    // 输出数
    private int lineOutSum;
    // 单灯控制器数
    private int slcSum;
    // 单灯控制器数
    private int protocolVersion;
    // 软件版本号
    private int softwareVersion;
    // 硬件版本号
    private int hardwareVersion;
    // 自动发布时间间隔
    private int autoPublishTimeInterval;
    // ip
    private String ip;
    // 子网掩码
    private String subnetMask;
    // 网关
    private String gateway;
    // 端口
    private int port;
    // 服务器地址
    private String serviceIp;
    // apn
    private String apn;
    // 用户名
    private String account;
    // 密码
    private String accountPassword;
    // 保留字段
    private int reserve;
    // 电量自动上报时间
    private Date electricQuantityAutoReportTime;

    /**
     * 数据处理
     * @param data 原始消息报文
     * @param offset 消息头heard长度
     * @param length 数据长度
     */
    public void setParam(byte[] data, int offset, int length) {
        this.districtNo = RzIotString.getStringFromByteArray(data, offset, 4);
        this.manufacturerNo = RzIotString.getStringFromByteArray(data, offset + 4, 4);
        this.sn = RzIotString.getStringFromByteArray(data, offset + 8, 8);
        this.phaseType = RzIotDigit.getUnInt16(data, offset + 16);
        this.lineOutSum = RzIotDigit.getUnInt16(data, offset + 18);
        this.slcSum = RzIotDigit.getUnInt16(data, offset + 20);
        this.protocolVersion = RzIotDigit.getUnInt16(data, offset + 22);
        this.softwareVersion = RzIotDigit.getUnInt16(data, offset + 24);
        this.hardwareVersion = RzIotDigit.getUnInt16(data, offset + 26);
        this.autoPublishTimeInterval = RzIotDigit.getUnInt16(data, offset + 28);
        this.ip = RzIotDigit.getUnInt(data, offset + 30) + "." + RzIotDigit.getUnInt(data, offset + 31) + "." + RzIotDigit.getUnInt(data, offset + 32) + "." + RzIotDigit.getUnInt(data, offset + 33);
        this.subnetMask = RzIotDigit.getUnInt(data, offset + 34) + "." + RzIotDigit.getUnInt(data, offset + 35) + "." + RzIotDigit.getUnInt(data, offset + 36) + "." + RzIotDigit.getUnInt(data, offset + 37);
        this.gateway = RzIotDigit.getUnInt(data, offset + 38) + "." + RzIotDigit.getUnInt(data, offset + 39) + "." + RzIotDigit.getUnInt(data, offset + 40) + "." + RzIotDigit.getUnInt(data, offset + 41);
        this.port = RzIotDigit.getUnInt16(data, offset + 42);
        this.serviceIp = RzIotDigit.getUnInt(data, offset + 44) + "." + RzIotDigit.getUnInt(data, offset + 45) + "." + RzIotDigit.getUnInt(data, offset + 46) + "." + RzIotDigit.getUnInt(data, offset + 47);
        this.account = RzIotString.getStringFromByteArray(data, offset + 48, 24);
        this.accountPassword = RzIotString.getStringFromByteArray(data, offset + 72, 24);
        this.apn = RzIotString.getStringFromByteArray(data, offset + 96, 24);
        this.reserve = RzIotDigit.getUnInt(data, offset + 16);
        try {
            int second = RzIotDigit.getUnInt(data, offset + 121);
            int minute = RzIotDigit.getUnInt(data, offset + 122);
            int hour = RzIotDigit.getUnInt(data, offset + 123);
            if (second > 0 && minute > 0 && hour > 0) {
                this.electricQuantityAutoReportTime = RzIotDatetime.stringToDate(hour + ":" + minute + ":" + second, "HH:mm:ss");
            }
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
    }
}
