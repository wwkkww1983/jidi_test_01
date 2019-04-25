package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mapper.IotConcentratorHeartbeatLogMapper;
import com.rz.iot.think.model.IotConcentratorHeartbeatLog;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器心跳 && 信号强度上报处理器
 */
@Component("concentratorSignalStrengthReportHandler")
public class ConcentratorSignalStrengthReportHandler implements IConcentratorReportHandlerService {

    @Resource
    private IotConcentratorHeartbeatLogMapper iotConcentratorHeartbeatLogMapper;
    @Override
    public void parse(ConcentratorMessageBase messageBase) {

        // 记录心跳
        IotConcentratorHeartbeatLog iotConcentratorHeartbeatLog = new IotConcentratorHeartbeatLog();
        iotConcentratorHeartbeatLog.setConcentratorId(messageBase.getConcentratorId());
        iotConcentratorHeartbeatLogMapper.insertSelective(iotConcentratorHeartbeatLog);
    }
}
