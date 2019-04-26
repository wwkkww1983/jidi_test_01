package com.rz.iot.think.mqtt.handler;

import com.rz.iot.think.mapper.IotConcentratorMapper;
import com.rz.iot.think.model.IotConcentrator;
import com.rz.iot.think.mqtt.handler.report.IConcentratorReportHandlerService;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.util.ConcentratorUtils;
import com.rz.iot.think.mqtt.util.MQTTStringUtils;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/4/10.
 * PS: Not easy to write code, please indicate.
 * Description：消息分发处理
 */
@Component("messageHandler")
@Slf4j
public class MQTTMessageHandler implements MessageHandler {

    @Resource
    private IConcentratorReportHandlerService concentratorAuthReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorConfigParamReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorCurrentTimeReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorElectricParamReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorEnergyReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorEnvironmentParamReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorFaultParamReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorFaultReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorRemoteUpgradeReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorSignalStrengthReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorSwitchStatusReportHandler;
    @Resource
    private IConcentratorReportHandlerService concentratorSwitchStrategyReportHandler;
    @Resource
    private IotConcentratorMapper iotConcentratorMapper;


    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

        log.info("收到集中器上报: {}", message);

        String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
        log.info("报文主题：{}", topic);
        String payLoad = message.getPayload().toString();

        log.info("未解码原始报文: {}", payLoad);

        byte[] data = MQTTStringUtils.hexStringToBytes(payLoad);
        ConcentratorMessageBase messageBase = new ConcentratorMessageBase();
        messageBase.decode(data);

        String sn = messageBase.getSerialNo();
        if (!StringUtils.isEmpty(sn)) {

            IotConcentrator concentratorFromUtils = ConcentratorUtils.get(sn);
            if (concentratorFromUtils != null) {
                messageBase.setConcentratorId(concentratorFromUtils.getId());
            } else {
                // 查询集中器id
                IotConcentrator concentrator = iotConcentratorMapper.findBySn(sn);
                if (concentrator != null) {
                    ConcentratorUtils.add(concentrator);
                    messageBase.setConcentratorId(concentrator.getId());
                }
            }
        }

        log.info("解码后报文: {}", messageBase);

        int operateCode = messageBase.getOperateCode();
        switch (operateCode) {
            case RzIotConcentratorConstParam.REPORT_OF_FAULT:
                // 告警数据上报
                log.info("告警数据上报");
                concentratorFaultReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_SWITCH_STATUS:
                // 输出（开关）状态上报
                log.info("输出（开关）状态上报");
                concentratorSwitchStatusReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_ELECTRIC_PARAM:
                // 电气参数上报
                log.info("电气参数上报");
                concentratorElectricParamReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_FAULT_PARAM:
                // 告警参数上报
                log.info("告警参数上报");
                concentratorFaultParamReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_CONFIG_PARAM:
                // 配置参数上报
                log.info("配置参数上报");
                concentratorConfigParamReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_CURRENT_TIME:
                // 当前时间上报
                log.info("当前时间上报");
                concentratorCurrentTimeReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_SWITCH_STRATEGY:
                // 开关策略（预约方案）上报
                log.info("开关策略（预约方案）上报");
                concentratorSwitchStrategyReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_ENERGY:
                // 电量上报
                log.info("电量上报");
                concentratorEnergyReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_ENVIRONMENT_PARAM:
                // 环境参数上报
                log.info("环境参数上报");
                concentratorEnvironmentParamReportHandler.parse(messageBase);
                break;

            case RzIotConcentratorConstParam.REPORT_OF_HEARTBEAT_AND_SIGNAL_STRENGTH:
                // 心跳 && 信号强度上报
                log.info("心跳 && 信号强度上报");
                concentratorSignalStrengthReportHandler.parse(messageBase);
                break;

            case RzIotConcentratorConstParam.REPORT_OF_AUTH:
                // 身份认证上报（登录）
                log.info("身份认证上报（登录）");
                concentratorAuthReportHandler.parse(messageBase);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_REMOTE_UPGRADE:
                // 升级步骤上报
                log.info("升级步骤上报");
                concentratorRemoteUpgradeReportHandler.parse(messageBase);
                break;
        }
    }
}
