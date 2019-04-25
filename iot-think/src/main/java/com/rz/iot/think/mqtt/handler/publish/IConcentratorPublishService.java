package com.rz.iot.think.mqtt.handler.publish;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.mqtt.model.publish.*;

import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器消息下发入口接口
 */
public interface IConcentratorPublishService {

    /**
     * 服务端输出控制命令下发
     * @param ctrlCmdPublishes
     * @param concentratorSn
     */
    void publishCtrlCmd(List<ConcentratorCtrlCmdPublish> ctrlCmdPublishes, String concentratorSn);

    /**
     * 服务端告警参数下发
     * @param warnConfigPublishes
     * @param concentratorSn
     */
    void warnConfigPublish(List<ConcentratorWarnConfigPublish> warnConfigPublishes, String concentratorSn);

    /**
     * 校时命令下发
     * @param concentratorSn
     */
    void timingPublish(String concentratorSn);

    /**
     * 服务端预约参数下发
     * @param switchStrategyPublish
     */
    void publishSwitchStrategy(ConcentratorSwitchStrategyPublish switchStrategyPublish, String concentratorSn);

    /***
     * 电量定时上报时间下发
     * @param concentratorElectricTimingReportTimePublish
     * @param concentratorSn
     */
    void publishElectricTimingReportTime(ConcentratorElectricTimingReportTimePublish concentratorElectricTimingReportTimePublish, String concentratorSn);


    /***
     * 服务端控制命令下发
     * @param concentratorCmdPublish
     * @param concentratorSn
     */
    void publishCmd(ConcentratorCmdPublish concentratorCmdPublish, String concentratorSn);

    /**
     * 服务端升级指令下发
     * @param remoteUpgradePublish
     * @param concentratorSn
     */
    Result publishRemoteUpgrade(ConcentratorRemoteUpgradePublish remoteUpgradePublish, String concentratorSn);

}
