package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mapper.IotConcentratorLineInMapper;
import com.rz.iot.think.mapper.IotConcentratorLineInPowerLogMapper;
import com.rz.iot.think.mapper.IotConcentratorLineInPowerMapper;
import com.rz.iot.think.mapper.IotConcentratorLineOutMapper;
import com.rz.iot.think.model.IotConcentratorLineIn;
import com.rz.iot.think.model.IotConcentratorLineInPower;
import com.rz.iot.think.model.IotConcentratorLineInPowerLog;
import com.rz.iot.think.model.IotConcentratorLineOut;
import com.rz.iot.think.mqtt.model.ConcentratorLineIn;
import com.rz.iot.think.mqtt.model.ConcentratorLineOut;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.report.ConcentratorElectricParamReport;
import com.rz.iot.think.mqtt.model.report.ConcentratorElectricQuantityReport;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器电气参数上报处理器
 */
@Component("concentratorElectricParamReportHandler")
public class ConcentratorElectricParamReportHandler implements IConcentratorReportHandlerService {

    @Resource
    private IotConcentratorLineInMapper iotConcentratorLineInMapper;
    @Resource
    private IotConcentratorLineInPowerMapper iotConcentratorLineInPowerMapper;
    @Resource
    private IotConcentratorLineInPowerLogMapper iotConcentratorLineInPowerLogMapper;
    @Resource
    private IotConcentratorLineOutMapper iotConcentratorLineOutMapper;

    @Override
    public void parse(ConcentratorMessageBase messageBase) {

        ConcentratorElectricParamReport electricParam = (ConcentratorElectricParamReport) messageBase.getObject();
        List<ConcentratorLineIn> lineInList = electricParam.getLineInList();
        List<ConcentratorLineOut> lineOutList = electricParam.getLineOutList();

        // 进线
        for (ConcentratorLineIn item : lineInList) {

            IotConcentratorLineIn lineIn = iotConcentratorLineInMapper.findByLineInType(item.getType(), messageBase.getConcentratorId());
            if (lineIn == null) {
                // 不存在该进线，插入
                lineIn = new IotConcentratorLineIn();
                lineIn.setName(item.getName());
                lineIn.setConcentratorId(messageBase.getConcentratorId());
                lineIn.setStatus(RzIotDBConstParam.DATA_STATUS_OF_NORMAL);
                lineIn.setType(item.getType());
                iotConcentratorLineInMapper.insertSelective(lineIn);
            }

            IotConcentratorLineInPower iotConcentratorLineInPower = new IotConcentratorLineInPower();
            // 进线id
            iotConcentratorLineInPower.setLineInId(lineIn.getId());
            // 电压
            iotConcentratorLineInPower.setVoltage(item.getVoltage());
            // 电流
            iotConcentratorLineInPower.setElectricCurrent(item.getElectricCurrent());
            // 剩余电流
            iotConcentratorLineInPower.setRemainCurrent(electricParam.getRemainCurrent());
            // 功率因素
            iotConcentratorLineInPower.setPowerFactor(item.getPowerFactor());
            // 视在功率
            iotConcentratorLineInPower.setApparentPower(item.getApparentPower());
            // 有功功率
            iotConcentratorLineInPower.setActivePower(item.getActivePower());
            // 无功功率
            iotConcentratorLineInPower.setReactivePower(item.getReactivePower());
            // 电网频率
            iotConcentratorLineInPower.setLineFrequency(electricParam.getGridFreq());

            IotConcentratorLineInPower lineInPower = iotConcentratorLineInPowerMapper.findByLineInId(lineIn.getId());

            if (lineInPower == null) {
                iotConcentratorLineInPowerMapper.insertSelective(iotConcentratorLineInPower);
            } else {
                iotConcentratorLineInPower.setId(lineInPower.getId());
                iotConcentratorLineInPowerMapper.updateByPrimaryKeySelective(iotConcentratorLineInPower);
            }

            // 记录log
            IotConcentratorLineInPowerLog iotConcentratorLineInPowerLog = new IotConcentratorLineInPowerLog();
            iotConcentratorLineInPowerLog.setLineInId(iotConcentratorLineInPower.getLineInId());
            iotConcentratorLineInPowerLog.setVoltage(iotConcentratorLineInPower.getVoltage());
            iotConcentratorLineInPowerLog.setElectricCurrent(iotConcentratorLineInPower.getElectricCurrent());
            iotConcentratorLineInPowerLog.setRemainCurrent(iotConcentratorLineInPower.getRemainCurrent());
            iotConcentratorLineInPowerLog.setPowerFactor(iotConcentratorLineInPower.getPowerFactor());
            iotConcentratorLineInPowerLog.setApparentPower(iotConcentratorLineInPower.getApparentPower());
            iotConcentratorLineInPower.setActivePower(iotConcentratorLineInPower.getApparentPower());
            iotConcentratorLineInPowerLog.setReactivePower(iotConcentratorLineInPower.getReactivePower());
            iotConcentratorLineInPowerLog.setLineFrequency(iotConcentratorLineInPower.getLineFrequency());
            iotConcentratorLineInPowerLogMapper.insertSelective(iotConcentratorLineInPowerLog);
        }

        // 输出
        for (ConcentratorLineOut lineOut : lineOutList) {

            IotConcentratorLineOut iotConcentratorLineOut = iotConcentratorLineOutMapper.findByNo(messageBase.getConcentratorId(), lineOut.getNo());
            if (iotConcentratorLineOut == null) {

                iotConcentratorLineOut = new IotConcentratorLineOut();
                iotConcentratorLineOut.setName(lineOut.getName());
                iotConcentratorLineOut.setNo(lineOut.getNo());
                iotConcentratorLineOut.setConcentratorId(messageBase.getConcentratorId());
                iotConcentratorLineOutMapper.insertSelective(iotConcentratorLineOut);
            }
        }
    }
}
