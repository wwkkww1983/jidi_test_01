package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mapper.IotConcentratorLineOutMapper;
import com.rz.iot.think.mapper.IotSingleLightControllerMapper;
import com.rz.iot.think.model.IotConcentratorLineOut;
import com.rz.iot.think.model.IotSingleLightController;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.report.ConcentratorLineOutReport;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器输出（开关）状态上报处理器
 */
@Component("concentratorSwitchStatusReportHandler")
public class ConcentratorSwitchStatusReportHandler implements IConcentratorReportHandlerService {

    @Resource
    private IotConcentratorLineOutMapper iotConcentratorLineOutMapper;
    @Resource
    private IotSingleLightControllerMapper iotSingleLightControllerMapper;

    @Override
    public void parse(ConcentratorMessageBase messageBase) {

        /*负责单灯控制器新增*/

        List<ConcentratorLineOutReport> lineOutReports = (List<ConcentratorLineOutReport>) messageBase.getObject();

        for (ConcentratorLineOutReport item : lineOutReports) {

            Integer source = item.getSource();
            switch (source) {
                case RzIotConcentratorConstParam.CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_LOOP:
                    // 回路
                    break;
                case RzIotConcentratorConstParam.CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_LINE_OUT:
                    // 输出
                    IotConcentratorLineOut iotConcentratorLineOut = iotConcentratorLineOutMapper.findByNo(messageBase.getConcentratorId(), item.getNumber());
                    if (iotConcentratorLineOut != null) {
                        iotConcentratorLineOut.setSwitchStatus(item.getStatus());
                        iotConcentratorLineOutMapper.updateByPrimaryKeySelective(iotConcentratorLineOut);
                    }
                    break;
                case RzIotConcentratorConstParam.CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_LINE_IN:
                    // 输入
                    break;
                case RzIotConcentratorConstParam.CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_SLC:
                    // 单灯控制器
                    String sn = messageBase.getSerialNo() + "_" + item.getNumber();
                    IotSingleLightController iotSingleLightController = iotSingleLightControllerMapper.findBySn(sn);
                    if (iotSingleLightController == null) {
                        // 增加单灯控制器
                        iotSingleLightController = new IotSingleLightController();
                        iotSingleLightController.setName("第" + item.getNumber() + "单灯控制器");
                        iotSingleLightController.setNo(item.getNumber());
                        iotSingleLightController.setConcentratorId(messageBase.getConcentratorId());
                        iotSingleLightController.setStatus(RzIotDBConstParam.DEVICE_STATUS_OF_NORMAL);
                        iotSingleLightController.setSwitchStatus(RzIotDBConstParam.DEVICE_SWITCH_STATUS_OF_ON);
                        iotSingleLightControllerMapper.insertSelective(iotSingleLightController);
                    } else {
                        // 更新单灯控制器
                        iotSingleLightController.setStatus(RzIotDBConstParam.DEVICE_STATUS_OF_NORMAL);
                        iotSingleLightController.setSwitchStatus(RzIotDBConstParam.DEVICE_SWITCH_STATUS_OF_ON);
                        iotSingleLightControllerMapper.updateByPrimaryKeySelective(iotSingleLightController);
                    }
                    break;
            }
        }

    }
}
