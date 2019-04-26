package com.rz.iot.think.mqtt.model.report;

import com.rz.iot.think.mqtt.model.ConcentratorLineIn;
import com.rz.iot.think.mqtt.model.ConcentratorLineOut;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import com.rz.iot.utils.RzIotDigit;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/12.
 * PS: Not easy to write code, please indicate.
 * Description：集中器电气参数上报
 */
@Data
@Log4j2
public class ConcentratorElectricParamReport {

    // 集中器进线列表
    private List<ConcentratorLineIn> lineInList = new ArrayList();
    // 集中器输出列表
    private List<ConcentratorLineOut> lineOutList = new ArrayList();
    // 箱内温度
    private Integer boxTemperature = 0;
    // 电网频率
    private Integer gridFreq = 0;
    // 进线电能
    private Long activePower = 0L;
    // 进线剩余电流
    private Integer remainCurrent = 0;

    public ConcentratorElectricParamReport() {
    }

    /**
     * 数据处理
     * @param data 原始消息报文
     * @param offset 消息头heard长度
     * @param length 数据长度
     */
    public void setParam(byte[] data, int offset, int length) {

        // 进线A相
        ConcentratorLineIn lineInA = new ConcentratorLineIn();
        lineInA.setName("进线A相");
        lineInA.setType(RzIotConcentratorConstParam.TYPE_A_PHASE);
        // 进线B相
        ConcentratorLineIn lineInB = new ConcentratorLineIn();
        lineInA.setName("进线B相");
        lineInB.setType(RzIotConcentratorConstParam.TYPE_B_PHASE);
        // 进线C相
        ConcentratorLineIn lineInC = new ConcentratorLineIn();
        lineInA.setName("进线C相");
        lineInC.setType(RzIotConcentratorConstParam.TYPE_C_PHASE);

        // 电压
        lineInA.setVoltage(RzIotDigit.getUnInt16(data, offset + 4));
        lineInB.setVoltage(RzIotDigit.getUnInt16(data, offset + 6));
        lineInC.setVoltage(RzIotDigit.getUnInt16(data, offset + 8));
        // 电流
        lineInA.setElectricCurrent(RzIotDigit.getUnInt16(data, offset + 10));
        lineInB.setElectricCurrent(RzIotDigit.getUnInt16(data, offset + 12));
        lineInC.setElectricCurrent(RzIotDigit.getUnInt16(data, offset + 14));
        // 功率因素
        lineInA.setPowerFactor(RzIotDigit.getUnInt16(data, offset + 22));
        lineInB.setPowerFactor(RzIotDigit.getUnInt16(data, offset + 24));
        lineInC.setPowerFactor(RzIotDigit.getUnInt16(data, offset + 26));
        // 视在功率
        lineInA.setApparentPower(RzIotDigit.getUnInt16(data, offset + 30));
        lineInB.setApparentPower(RzIotDigit.getUnInt16(data, offset + 32));
        lineInC.setApparentPower(RzIotDigit.getUnInt16(data, offset + 34));
        // 有功功率
        lineInA.setActivePower(RzIotDigit.getUnInt16(data, offset + 38));
        lineInB.setActivePower(RzIotDigit.getUnInt16(data, offset + 40));
        lineInC.setActivePower(RzIotDigit.getUnInt16(data, offset + 42));
        // 无功功率
        lineInA.setReactivePower(RzIotDigit.getUnInt16(data, offset + 46));
        lineInB.setReactivePower(RzIotDigit.getUnInt16(data, offset + 48));
        lineInC.setReactivePower(RzIotDigit.getUnInt16(data, offset + 50));
        // 电缆温度
        lineInA.setCableTemperature(RzIotDigit.getUnInt16(data, offset + 56));
        lineInB.setCableTemperature(RzIotDigit.getUnInt16(data, offset + 58));
        lineInC.setCableTemperature(RzIotDigit.getUnInt16(data, offset + 60));

        this.lineInList.add(lineInA);
        this.lineInList.add(lineInB);
        this.lineInList.add(lineInC);
        int numLoops = (length - 62) / 4;

        for(int i = 0; i < numLoops; ++i) {
            ConcentratorLineOut lineOut = new ConcentratorLineOut();
            int no = i + 1;
            lineOut.setNo(no);
            lineOut.setName("第" + no + "输出");
            // 电流
            lineOut.setElectricCurrent(RzIotDigit.getUnInt16(data, offset + 62 + i * 4));
            // 有功功率
            lineOut.setActivePower(RzIotDigit.getUnInt16(data, offset + 62 + i * 4 + 2));
            this.lineOutList.add(lineOut);
        }

        // 进线电能
        this.setActivePower(RzIotDigit.getUnInt32(data, offset));
        // 电网频率
        this.setGridFreq(RzIotDigit.getUnInt16(data, offset + 52));
        // 箱内温度
        this.setBoxTemperature(RzIotDigit.getUnInt16(data, offset + 54));
        // 进线剩余电流
        this.setRemainCurrent(RzIotDigit.getUnInt16(data, offset + 18));
    }
}
