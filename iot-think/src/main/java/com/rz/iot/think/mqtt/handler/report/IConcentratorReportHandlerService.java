package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器消息上报消息处理接口
 */
public interface IConcentratorReportHandlerService {

    void parse(ConcentratorMessageBase messageBase);
}
