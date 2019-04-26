package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mapper.*;
import com.rz.iot.think.model.*;
import com.rz.iot.think.mqtt.model.ConcentratorElectricQuantity;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.SingleLightControllerElectricQuantity;
import com.rz.iot.think.mqtt.model.report.ConcentratorElectricQuantityReport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器电量上报处理器
 */
@Component("concentratorEnergyReportHandler")
public class ConcentratorEnergyReportHandler implements IConcentratorReportHandlerService {

    @Resource
    private IotConcentratorPowerMapper iotConcentratorPowerMapper;
    @Resource
    private IotConcentratorPowerLogMapper iotConcentratorPowerLogMapper;
    @Resource
    private IotSingleLightControllerPowerMapper iotSingleLightControllerPowerMapper;
    @Resource
    private IotSingleLightControllerMapper iotSingleLightControllerMapper;
    @Resource
    private IotSingleLightControllerPowerLogMapper iotSingleLightControllerPowerLogMapper;


    @Override
    public void parse(ConcentratorMessageBase messageBase) {

        ConcentratorElectricQuantityReport electricQuantityReport = (ConcentratorElectricQuantityReport) messageBase.getObject();

        // 集中器电量
        ConcentratorElectricQuantity concentratorElectricQuantity = electricQuantityReport.getConcentratorElectricQuantity();
        // 单灯控制器电量
        SingleLightControllerElectricQuantity slcElectricQuantity = electricQuantityReport.getSlcElectricQuantity();

        IotConcentratorPower iotConcentratorPower = iotConcentratorPowerMapper.findByConcentratorId(messageBase.getConcentratorId());
        if (iotConcentratorPower == null) {

            iotConcentratorPower = new IotConcentratorPower();
            iotConcentratorPower.setConcentratorId(messageBase.getConcentratorId());
            iotConcentratorPower.setActivePower(new Integer(concentratorElectricQuantity.getValue() + ""));
            iotConcentratorPowerMapper.insertSelective(iotConcentratorPower);
        } else {
            iotConcentratorPower.setActivePower(new Integer(concentratorElectricQuantity.getValue() + ""));
            iotConcentratorPowerMapper.updateByPrimaryKeySelective(iotConcentratorPower);
        }

        // 记录日志
        IotConcentratorPowerLog iotConcentratorPowerLog = new IotConcentratorPowerLog();
        iotConcentratorPowerLog.setActivePower(new Integer(concentratorElectricQuantity.getValue() + ""));
        iotConcentratorPowerLog.setConcentratorId(messageBase.getConcentratorId());
        iotConcentratorPowerLogMapper.insertSelective(iotConcentratorPowerLog);

        // 单灯控制器
        String slcSn = messageBase.getSerialNo() + "_" + slcElectricQuantity.getNo();
        IotSingleLightController iotSingleLightController = iotSingleLightControllerMapper.findBySn(slcSn);

        IotSingleLightControllerPower iotSingleLightControllerPower = iotSingleLightControllerPowerMapper.findBySlcSn(slcSn);
        if (iotSingleLightControllerPower == null) {

            iotSingleLightControllerPower = new IotSingleLightControllerPower();
            iotSingleLightControllerPower.setActivePower(new Integer(slcElectricQuantity.getValue() + ""));
            if (iotSingleLightController != null) {
                iotSingleLightControllerPower.setSlcId(iotSingleLightController.getId());
            }
        } else {
            iotSingleLightControllerPower.setActivePower(new Integer(slcElectricQuantity.getValue() + ""));
            iotSingleLightControllerPowerMapper.updateByPrimaryKeySelective(iotSingleLightControllerPower);
        }

        // 记录日志
        IotSingleLightControllerPowerLog iotSingleLightControllerPowerLog = new IotSingleLightControllerPowerLog();
        iotSingleLightControllerPowerLog.setActivePower(new Integer(slcElectricQuantity.getValue() + ""));
        if (iotSingleLightController != null) {
            iotSingleLightControllerPowerLog.setSlcId(iotSingleLightController.getId());
        }
        iotSingleLightControllerPowerLogMapper.insertSelective(iotSingleLightControllerPowerLog);
    }
}
