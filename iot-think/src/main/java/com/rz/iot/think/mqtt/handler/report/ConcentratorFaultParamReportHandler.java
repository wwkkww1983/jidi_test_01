package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import org.springframework.stereotype.Component;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器告警参数上报处理器
 */
@Component("concentratorFaultParamReportHandler")
public class ConcentratorFaultParamReportHandler implements IConcentratorReportHandlerService {
    @Override
    public void parse(ConcentratorMessageBase messageBase) {
        // 暂不做处理
    }
}
