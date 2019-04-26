package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mapper.*;
import com.rz.iot.think.model.*;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.report.ConcentratorFaultReport;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器告警数据上报处理器
 */
@Component("concentratorFaultReportHandler")
public class ConcentratorFaultReportHandler implements IConcentratorReportHandlerService {

    @Resource
    private IotConcentratorFaultMapper iotConcentratorFaultMapper;
    @Resource
    private IotConcentratorFaultLogMapper iotConcentratorFaultLogMapper;
    @Resource
    private IotSingleLightControllerFaultMapper iotSingleLightControllerFaultMapper;
    @Resource
    private IotSingleLightControllerFaultLogMapper iotSingleLightControllerFaultLogMapper;
    @Resource
    private IotSingleLightControllerMapper iotSingleLightControllerMapper;

    @Override
    public void parse(ConcentratorMessageBase messageBase) {

        List<ConcentratorFaultReport> faultReports = (List<ConcentratorFaultReport>) messageBase.getObject();
        for (ConcentratorFaultReport faultReport : faultReports) {

            Integer faultSource = faultReport.getFaultSource();
            switch (faultSource) {
                case RzIotConcentratorConstParam.CONCENTRATOR_FAULT_REPORT_SOURCE_OF_SLC:
                    // 单灯控制器
                    String slcSn = messageBase.getSerialNo() + "_" + faultReport.getFaultNumber();
                    IotSingleLightController singleLightController = iotSingleLightControllerMapper.findBySn(slcSn);

                    if (singleLightController != null) {
                        Integer slcId = singleLightController.getId();
                        IotSingleLightControllerFault singleLightControllerFault = iotSingleLightControllerFaultMapper.findByType(faultReport.getFaultInfo(), slcId);

                        if (singleLightControllerFault == null) {
                            singleLightControllerFault.setType(faultReport.getFaultInfo());
                            singleLightControllerFault.setSlcId(slcId);
                            singleLightControllerFault.setLevel(faultReport.getLevel());
                            singleLightControllerFault.setStatus(faultReport.getFaultValue());
                            iotSingleLightControllerFaultMapper.insertSelective(singleLightControllerFault);
                        } else {
                            if (singleLightControllerFault.getStatus() != faultReport.getFaultValue()) {
                                // 状态改变 更新
                                singleLightControllerFault.setType(faultReport.getFaultInfo());
                                singleLightControllerFault.setSlcId(slcId);
                                singleLightControllerFault.setLevel(faultReport.getLevel());
                                singleLightControllerFault.setStatus(faultReport.getFaultValue());
                                iotSingleLightControllerFaultMapper.updateByPrimaryKeySelective(singleLightControllerFault);
                            }
                        }
                        // 记录日志
                        IotSingleLightControllerFaultLog iotSingleLightControllerFaultLog = new IotSingleLightControllerFaultLog();
                        iotSingleLightControllerFaultLog.setType(faultReport.getFaultInfo());
                        iotSingleLightControllerFaultLog.setSlcId(slcId);
                        iotSingleLightControllerFaultLog.setLevel(faultReport.getLevel());
                        iotSingleLightControllerFaultLog.setStatus(faultReport.getFaultValue());
                        iotSingleLightControllerFaultLogMapper.insertSelective(iotSingleLightControllerFaultLog);
                    }

                    break;
                default:
                    // 进线、输出
                    IotConcentratorFault iotConcentratorFault = iotConcentratorFaultMapper.findByType(faultReport.getFaultInfo(), messageBase.getConcentratorId());
                    if (iotConcentratorFault == null) {
                        iotConcentratorFault.setType(faultReport.getFaultInfo());
                        iotConcentratorFault.setConcentratorId(messageBase.getConcentratorId());
                        iotConcentratorFault.setLevel(faultReport.getLevel());
                        iotConcentratorFault.setStatus(faultReport.getFaultValue());
                        iotConcentratorFaultMapper.insertSelective(iotConcentratorFault);
                    } else {
                        if (iotConcentratorFault.getStatus() != faultReport.getFaultValue()) {
                            // 状态改变 更新
                            iotConcentratorFault.setType(faultReport.getFaultInfo());
                            iotConcentratorFault.setConcentratorId(messageBase.getConcentratorId());
                            iotConcentratorFault.setLevel(faultReport.getLevel());
                            iotConcentratorFault.setStatus(faultReport.getFaultValue());
                            iotConcentratorFaultMapper.updateByPrimaryKeySelective(iotConcentratorFault);
                        }
                    }
                    // 记录日志
                    IotConcentratorFaultLog iotConcentratorFaultLog = new IotConcentratorFaultLog();
                    iotConcentratorFaultLog.setType(faultReport.getFaultInfo());
                    iotConcentratorFaultLog.setConcentratorId(messageBase.getConcentratorId());
                    iotConcentratorFaultLog.setLevel(faultReport.getLevel());
                    iotConcentratorFaultLog.setStatus(faultReport.getFaultValue());
                    iotConcentratorFaultLogMapper.insertSelective(iotConcentratorFaultLog);
            }
        }
    }
}
