package com.rz.iot.think.mqtt.model.report;

import com.rz.iot.think.mqtt.model.ConcentratorLineInFaultParam;
import com.rz.iot.think.mqtt.model.ConcentratorLineOutLoopFaultParam;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import com.rz.iot.utils.RzIotDigit;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/12.
 * PS: Not easy to write code, please indicate.
 * Description：集中器告警参数上报
 */
public class ConcentratorFaultParamReport {

    private List<ConcentratorLineInFaultParam> lineInFaultParams = new ArrayList<>();
    private List<ConcentratorLineOutLoopFaultParam> lineOutLoopFaultParams = new ArrayList<>();

    /**
     * 数据处理
     * @param data 原始消息报文
     * @param offset 消息头heard长度
     * @param length 数据长度
     */
    public void setParam(byte[] data, int offset, int length) {

        // 进线A
        ConcentratorLineInFaultParam lineInFaultParamA = new ConcentratorLineInFaultParam();
        lineInFaultParamA.setName("进线A告警参数");
        lineInFaultParamA.setType(RzIotConcentratorConstParam.TYPE_B_PHASE);
        // 进线B
        ConcentratorLineInFaultParam lineInFaultParamB = new ConcentratorLineInFaultParam();
        lineInFaultParamB.setName("进线B告警参数");
        lineInFaultParamB.setType(RzIotConcentratorConstParam.TYPE_B_PHASE);
        // 进线C
        ConcentratorLineInFaultParam lineInFaultParamC = new ConcentratorLineInFaultParam();
        lineInFaultParamC.setName("进线C告警参数");
        lineInFaultParamC.setType(RzIotConcentratorConstParam.TYPE_B_PHASE);

        // 电压保护上限
        lineInFaultParamA.setVoltageProtectMax(RzIotDigit.getUnInt16(data, offset));
        lineInFaultParamB.setVoltageProtectMax(RzIotDigit.getUnInt16(data, offset + 6));
        lineInFaultParamC.setVoltageProtectMax(RzIotDigit.getUnInt16(data, offset + 12));

        // 电压告警上限
        lineInFaultParamA.setVoltageWarnMax(RzIotDigit.getUnInt16(data, offset + 2));
        lineInFaultParamB.setVoltageWarnMax(RzIotDigit.getUnInt16(data, offset + 8));
        lineInFaultParamC.setVoltageWarnMax(RzIotDigit.getUnInt16(data, offset + 14));

        // 电压告警下限
        lineInFaultParamA.setVoltageWarnMin(RzIotDigit.getUnInt16(data, offset + 4));
        lineInFaultParamB.setVoltageWarnMin(RzIotDigit.getUnInt16(data, offset + 10));
        lineInFaultParamC.setVoltageWarnMin(RzIotDigit.getUnInt16(data, offset + 16));

        // 电流保护上限
        lineInFaultParamA.setElectricCurrentProtectMax(RzIotDigit.getUnInt16(data, offset + 18));
        lineInFaultParamB.setElectricCurrentProtectMax(RzIotDigit.getUnInt16(data, offset + 22));
        lineInFaultParamC.setElectricCurrentProtectMax(RzIotDigit.getUnInt16(data, offset + 26));

        // 电流告警上限
        lineInFaultParamA.setElectricCurrentWarnMax(RzIotDigit.getUnInt16(data, offset + 20));
        lineInFaultParamB.setElectricCurrentWarnMax(RzIotDigit.getUnInt16(data, offset + 24));
        lineInFaultParamC.setElectricCurrentWarnMax(RzIotDigit.getUnInt16(data, offset + 28));

        lineInFaultParams.add(lineInFaultParamA);
        lineInFaultParams.add(lineInFaultParamB);
        lineInFaultParams.add(lineInFaultParamC);

        int numLoops = (length - 38) / 2;

        for(int i = 0; i < numLoops; ++i) {
            int no = i + 1;
            ConcentratorLineOutLoopFaultParam lineOutLoopFaultParam = new ConcentratorLineOutLoopFaultParam();
            lineOutLoopFaultParam.setName("第" + no + "回路告警参数");
            // 电流保护上限
            lineOutLoopFaultParam.setElectricCurrentProtectMax(RzIotDigit.getUnInt16(data, offset + 38 + 2 * i));
            // 电流告警上限
            lineOutLoopFaultParam.setElectricCurrentWarnMax(RzIotDigit.getUnInt16(data, offset + 38 + 2 * i + 2));
            lineOutLoopFaultParams.add(lineOutLoopFaultParam);
        }
    }
}
