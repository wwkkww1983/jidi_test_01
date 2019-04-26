package com.rz.iot.think.mqtt.test;
import com.rz.iot.think.mqtt.handler.MqttGateway;
import com.rz.iot.think.mqtt.handler.publish.IConcentratorPublishService;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.ConcentratorSwitchStrategy;
import com.rz.iot.think.mqtt.model.Pole;
import com.rz.iot.think.mqtt.model.publish.ConcentratorCmdPublish;
import com.rz.iot.think.mqtt.model.publish.ConcentratorElectricTimingReportTimePublish;
import com.rz.iot.think.mqtt.model.publish.ConcentratorSwitchStrategyPublish;
import com.rz.iot.think.mqtt.model.report.ConcentratorAppointParamReport;
import com.rz.iot.think.mqtt.util.MsgIdUtils;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import com.rz.iot.utils.MD5;
import com.rz.iot.utils.RzIotDatetime;
import com.rz.iot.utils.RzIotDigit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:jidi
 * @Date:2019/04/17 15:54
 * @Description: mqtt测试类
 **/

@RestController
@RequestMapping("/test")
public class MqttTest {

    @Resource
    private MqttGateway mqttGateway;
    @Resource
    private IConcentratorPublishService iConcentratorPublishService;

    @RequestMapping("/sendMqtt")
    public void sendMqtt() {
        StringBuffer sb = new StringBuffer();
        // 操作码
        sb.append(RzIotDigit.intToHexString(RzIotConcentratorConstParam.REPORT_OF_ENVIRONMENT_PARAM, 1));
        // 加密标志
        sb.append(RzIotDigit.intToHexString(0, 1));
        // 消息ID
        sb.append(RzIotDigit.intToHexString(MsgIdUtils.getMsgId(), 2));
        // 时间戳
        sb.append(RzIotDigit.longToHexString(RzIotDatetime.getTimestamp(), 4));
        // 集中器序列号
        sb.append(RzIotDigit.charArrayToHexString("0762000720191303".toCharArray(), 16));
        String number = RzIotDigit.charArrayToHexString("0762000720191303".toCharArray(),16);
//        sb.append(RzIotDigit.intToHexString(32, 2));
//        sb.append("010059006728EA593036333330303031313730353030363008000100010101010101");

        sb.append(RzIotDigit.intToHexString(24, 2));
        //环境参数测试
         sb.append("500050005000500000000000000050005000500050000000");
        //预约参数测试
        //sb.append("03010101010101000001000002050000000000000101500001010101010100000100000205000000000000010150000101010101010000010000020500000000000001015000");
        //System.out.println(sb.toString());
        mqttGateway.sendToMqtt(sb.toString(),"rz_iot_think");

        //预约参数下发测试
        /*ConcentratorSwitchStrategyPublish switchStrategyPublish = new ConcentratorSwitchStrategyPublish();
        switchStrategyPublish.setStrategyType(2);
        List<ConcentratorSwitchStrategy> concentratorSwitchStrategies = new ArrayList<>();
        ConcentratorSwitchStrategy concentratorSwitchStrategy = new ConcentratorSwitchStrategy();
        ConcentratorSwitchStrategy concentratorSwitchStrategy2 = new ConcentratorSwitchStrategy();

        concentratorSwitchStrategy.setNo(12);
        concentratorSwitchStrategy2.setNo(13);
        Date date = new Date();
        concentratorSwitchStrategy.setStartDate(date);
        concentratorSwitchStrategy.setStartMoveLight(date);
        concentratorSwitchStrategy.setStartTime(date);
        concentratorSwitchStrategy.setEndDate(date);
        concentratorSwitchStrategy.setEndMoveLight(date);
        concentratorSwitchStrategy.setEndTime(date);
        concentratorSwitchStrategy.setIntervalType(1);
        concentratorSwitchStrategy.setPercent(22);
        concentratorSwitchStrategy.setOutTag(4397);
        concentratorSwitchStrategy.setWeek(12);
        concentratorSwitchStrategy.setSwitchNo(1000);

        concentratorSwitchStrategy2.setStartDate(date);
        concentratorSwitchStrategy2.setStartMoveLight(date);
        concentratorSwitchStrategy2.setStartTime(date);
        concentratorSwitchStrategy2.setEndDate(date);
        concentratorSwitchStrategy2.setEndMoveLight(date);
        concentratorSwitchStrategy2.setEndTime(date);
        concentratorSwitchStrategy2.setIntervalType(2);
        concentratorSwitchStrategy2.setPercent(22);
        concentratorSwitchStrategy2.setOutTag(4396);
        concentratorSwitchStrategy2.setWeek(13);
        concentratorSwitchStrategy2.setSwitchNo(1000);
        List<Pole> poleList = new ArrayList<>();
        List<Pole> poleList2 = new ArrayList<>();

        for(int i=18 ; i<=272 ; i++){
            Pole pole = new Pole();
            Pole pole2 = new Pole();
            pole.setId(i);
            pole.setStatus(1);
            pole2.setId(i);
            pole2.setStatus(0);
            poleList.add(pole);
            poleList2.add(pole2);
        }
        concentratorSwitchStrategy.setPoleList(poleList);
        concentratorSwitchStrategy2.setPoleList(poleList2);
        concentratorSwitchStrategies.add(concentratorSwitchStrategy);
        concentratorSwitchStrategies.add(concentratorSwitchStrategy2);
        switchStrategyPublish.setConcentratorSwitchStrategies(concentratorSwitchStrategies);
        iConcentratorPublishService.publishSwitchStrategy(switchStrategyPublish,number);*/
        //830002008f185b3433303337333633323330333033303337 2e02 01 0c 130413 130413 06310e 06310e 06310e 06310e 16 0101010101010101010101010101010101

        //电量定时上报时间下发测试
        //ConcentratorElectricTimingReportTimePublish concentratorElectricTimingReportTimePublish = new ConcentratorElectricTimingReportTimePublish();
        //Date reportDate = new Date();
        //concentratorElectricTimingReportTimePublish.setReportDate(reportDate);
        //iConcentratorPublishService.publishElectricTimingReportTime(concentratorElectricTimingReportTimePublish, number);
        //85000200a575463433303337333633323330333033303337 0300 221a0e

        //控制命令下发测试
        //ConcentratorCmdPublish concentratorCmdPublish = new ConcentratorCmdPublish();
        //concentratorCmdPublish.setType(22);
        //iConcentratorPublishService.publishCmd(concentratorCmdPublish, number);
        //80000300b975463433303337333633323330333033303337 0100 01
    }


}
