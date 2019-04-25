package com.rz.iot.think.mqtt.handler.report;

import com.rz.iot.think.mapper.IotConcentratorMapper;
import com.rz.iot.think.model.IotConcentrator;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.report.ConcentratorAuthReport;
import com.rz.iot.think.utils.RzIotDBConstParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器身份认证上报处理器
 */
@Log4j2
@Component("concentratorAuthReportHandler")
public class ConcentratorAuthReportHandler implements IConcentratorReportHandlerService {

    @Resource
    private IotConcentratorMapper iotConcentratorMapper;

    @Override
    public void parse(ConcentratorMessageBase messageBase) {

        ConcentratorAuthReport authReport = (ConcentratorAuthReport) messageBase.getObject();
        Boolean auth = authReport.auth();
        if (auth) {
            log.debug("集中器sn={}，登录认证通过，username={}，password={}", messageBase.getSerialNo(), authReport.getUsername(), authReport.getPassword());
            IotConcentrator iotConcentrator = iotConcentratorMapper.findBySn(messageBase.getSerialNo());
            if (iotConcentrator == null) {
                // 新设备上报
                iotConcentrator = new IotConcentrator();
                iotConcentrator.setSn(messageBase.getSerialNo());
                iotConcentrator.setName("自动上报集中器" + messageBase.getSerialNo());
                iotConcentrator.setStatus(RzIotDBConstParam.DEVICE_STATUS_OF_NORMAL);
                iotConcentratorMapper.insertSelective(iotConcentrator);
            }

        } else {
            log.debug("集中器sn={}，登录认证失败，username={}，password={}", messageBase.getSerialNo(), authReport.getUsername(), authReport.getPassword());
        }
    }
}
