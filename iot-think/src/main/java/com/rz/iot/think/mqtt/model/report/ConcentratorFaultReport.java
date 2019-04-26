package com.rz.iot.think.mqtt.model.report;

import com.rz.iot.think.utils.RzIotDBConstParam;
import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/11.
 * PS: Not easy to write code, please indicate.
 * Description：集中器告警数据上报
 */
@Data
public class ConcentratorFaultReport {

    // 告警原始数据
    private byte[] faultData;
    // 告警原始数据字符串
    private String faultInfo;

    // 告警信号源 1：进线；2：输出；3：单灯控制器
    private Integer faultSource;
    // 告警编号（进线对应 1：A相；2：B相；3：C相；4：合相 输出对应第几输出 单灯控制器对应第几单灯）
    private Integer faultNumber;
    /**
     * 告警内容
     * 1：电流上限告警
     * 2：电流上限保护
     * 3：电压上限告警
     * 4：电压上限保护
     * 5：电压下限告警
     * 6：电压下限保护
     * 7：温度上限告警
     * 8：温度上限保护
     */
    private Integer faultContent;
    // 告警值 0：恢复；1：产生
    private Integer faultValue;
    // 错误级别：1：正常；2：告警；3：保护；4：离线
    private Integer level;

    public ConcentratorFaultReport(byte[] faultData, String faultInfo, Integer faultSource, Integer faultNumber, Integer faultContent, Integer faultValue) {
        this.faultData = faultData;
        this.faultInfo = faultInfo;
        this.faultSource = faultSource;
        this.faultNumber = faultNumber;
        this.faultContent = faultContent;
        this.faultValue = faultValue;
        this.level = this.faultContent % 2 == 0 ? RzIotDBConstParam.FAULT_LEVEL_OF_PROTECT : RzIotDBConstParam.FAULT_LEVEL_OF_WARNING;
    }

    public ConcentratorFaultReport() {

    }
}