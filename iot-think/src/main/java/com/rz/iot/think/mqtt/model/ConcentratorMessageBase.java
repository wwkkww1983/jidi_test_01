package com.rz.iot.think.mqtt.model;

import com.rz.iot.think.mqtt.handler.publish.ConcentratorPublishServiceImpl;
import com.rz.iot.think.mqtt.model.publish.*;
import com.rz.iot.think.mqtt.model.report.*;
import com.rz.iot.think.mqtt.util.MqttDateTimeUtils;
import com.rz.iot.think.mqtt.util.MsgIdUtils;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import com.rz.iot.utils.RzIotDatetime;
import com.rz.iot.utils.RzIotDigit;
import com.rz.iot.utils.RzIotString;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Author by xuxiake, Date on 2019/4/11.
 * PS: Not easy to write code, please indicate.
 * Description: 集中器消息传输基础类
 */
@Data
@Log4j2
public class ConcentratorMessageBase {

    // 操作码
    private int operateCode;
    // 加密标志
    private int encryptType;
    // 消息ID
    private int msgId;
    // 时间戳
    private long timestamp;
    // 集中器序列号
    private String serialNo;
    // 数据长度
    private int length;
    // 数据内容
    private Object object;

    // 集中器id（不包含在消息中）
    private int concentratorId;

    // 编码
    public String encode() {

        StringBuffer sb = new StringBuffer();

        // 操作码
        sb.append(RzIotDigit.intToHexString(operateCode, 1));
        // 加密标志
        sb.append(RzIotDigit.intToHexString(0, 1));
        // 消息ID
        sb.append(RzIotDigit.intToHexString(MsgIdUtils.getMsgId(), 2));
        // 时间戳
        sb.append(RzIotDigit.longToHexString(RzIotDatetime.getTimestamp(), 4));
        // 集中器序列号
        sb.append(RzIotDigit.charArrayToHexString(serialNo.toCharArray(), 16));
        // 数据内容以及数据长度
        switch (operateCode) {
            case RzIotConcentratorConstParam.PUBLISH_COMMON:
                // 服务端控制命令下发
                ConcentratorCmdPublish concentratorCmdPublish = (ConcentratorCmdPublish) this.object;
                sb.append(RzIotDigit.intToHexString(1,2));
                sb.append(RzIotDigit.intToHexString(concentratorCmdPublish.getType(),1));
                break;
            case RzIotConcentratorConstParam.PUBLISH_CTRL_CMD:
                // 服务端输出控制命令下发
                List<ConcentratorCtrlCmdPublish> ctrlCmdPublishes = (List<ConcentratorCtrlCmdPublish>) this.object;
                sb.append(RzIotDigit.intToHexString(ctrlCmdPublishes.size() * 4, 2));
                for (ConcentratorCtrlCmdPublish ctrlCmdPublish : ctrlCmdPublishes) {
                    sb.append(RzIotDigit.intToHexString(ctrlCmdPublish.getType(), 1));
                    sb.append(RzIotDigit.intToHexString(ctrlCmdPublish.getNo(), 1));
                    sb.append(RzIotDigit.intToHexString(ctrlCmdPublish.getNc(), 1));
                    sb.append(RzIotDigit.intToHexString(ctrlCmdPublish.getValue(), 1));
                }
                break;
            case RzIotConcentratorConstParam.PUBLISH_WARN_CONFIG:
                // 服务端告警参数下发
                List<ConcentratorWarnConfigPublish> warnConfigPublishes = (List<ConcentratorWarnConfigPublish>) this.object;
                sb.append(RzIotDigit.intToHexString(warnConfigPublishes.size() * 5, 2));
                for (ConcentratorWarnConfigPublish warnConfigPublish : warnConfigPublishes) {
                    sb.append(RzIotDigit.intToHexString(warnConfigPublish.getType(), 1));
                    sb.append(RzIotDigit.intToHexString(warnConfigPublish.getNo(), 1));
                    sb.append(RzIotDigit.intToHexString(warnConfigPublish.getNc(), 1));
                    sb.append(RzIotDigit.intToHexString(warnConfigPublish.getValue(), 2));
                }
                break;
            case RzIotConcentratorConstParam.PUBLISH_SWITCH_STRATEGY:
                // 服务端预约参数下发
                ConcentratorSwitchStrategyPublish switchStrategyPublish = (ConcentratorSwitchStrategyPublish) this.object;
                //预约参数类型
                Integer strategyType = switchStrategyPublish.getStrategyType();
                //预约参数数据集合
                List<ConcentratorSwitchStrategy> switchStrategies = switchStrategyPublish.getConcentratorSwitchStrategies();
                if(strategyType == RzIotConcentratorConstParam.CYCLE_TYPE_DATE){//日期
                    // 数据长度
                    sb.append(RzIotDigit.intToHexString(switchStrategies.size() * 279, 2));
                    for (ConcentratorSwitchStrategy switchStrategy : switchStrategies) {
                        sb.append(RzIotDigit.intToHexString(RzIotConcentratorConstParam.CYCLE_TYPE_DATE, 1));
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getNo(),1));
                        //起始日期
                        Map<String, Integer> startDateMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartDate());
                        sb.append(RzIotDigit.intToHexString((Integer)startDateMap.get("day"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startDateMap.get("month"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startDateMap.get("year"), 1));
                        //结束日期
                        Map<String, Integer> endDateMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndDate());
                        sb.append(RzIotDigit.intToHexString((Integer)endDateMap.get("day"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endDateMap.get("month"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endDateMap.get("year"), 1));
                        //开灯时间
                        Map<String, Integer> startTimeMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartTime());
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("second"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("minute"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("hour"), 1));
                        //关灯时间
                        Map<String, Integer> endTimeMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndTime());
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("second"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("minute"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("hour"), 1));
                        if(switchStrategy.getStartMoveLight() == null){//调光开始时间为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{
                            //调光开始时间
                            Map<String, Integer> startMoveLightMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartMoveLight());
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("second"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("minute"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("hour"), 1));
                        }
                        if(switchStrategy.getEndMoveLight() == null){//调光结束时间为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{
                            //调光结束时间
                            Map<String, Integer> endMoveLightMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndMoveLight());
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("second"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("minute"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("hour"), 1));
                        }
                        if((Integer)switchStrategy.getPercent() == null){//调光百分比为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{//调光百分比不为空
                            sb.append(RzIotDigit.intToHexString(switchStrategy.getPercent(),1));
                        }
                        if((Integer)switchStrategy. getIntervalType() == null){//隔杆模式为空
                            sb.append(RzIotConcentratorConstParam.POLE_MODEL_ALL); //默认全亮
                        }else{//隔杆模式不为空
                            sb.append(RzIotDigit.intToHexString(switchStrategy.getIntervalType(),1));
                        }
                        //隔杆控制集合
                        List<Pole> poleList = switchStrategy.getPoleList();
                        for(Pole pole : poleList ){
                            sb.append(RzIotDigit.intToHexString(pole.getStatus(),1));
                        }
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getOutTag(),2));
                    }
                }
                if(strategyType == RzIotConcentratorConstParam.CYCLE_TYPE_WEEK){//星期
                    // 数据长度
                    sb.append(RzIotDigit.intToHexString(switchStrategies.size() * 274, 2));
                    for (ConcentratorSwitchStrategy switchStrategy : switchStrategies) {
                        sb.append(RzIotDigit.intToHexString(RzIotConcentratorConstParam.CYCLE_TYPE_WEEK,1));
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getNo(),1));
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getWeek(),1));
                        //开灯时间
                        Map<String, Integer> startTimeMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartTime());
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("second"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("minute"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("hour"), 1));
                        //关灯时间
                        Map<String, Integer> endTimeMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndTime());
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("second"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("minute"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("hour"), 1));

                        if(switchStrategy.getStartMoveLight() == null){//调光开始时间为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{
                            //调光开始时间
                            Map<String, Integer> startMoveLightMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartMoveLight());
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("second"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("minute"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("hour"), 1));
                        }
                        if(switchStrategy.getEndMoveLight() == null){//调光结束时间为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{
                            //调光结束时间
                            Map<String, Integer> endMoveLightMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndMoveLight());
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("second"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("minute"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("hour"), 1));
                        }
                        if((Integer)switchStrategy.getPercent() == null){//调光百分比为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{//调光百分比不为空
                            sb.append(RzIotDigit.intToHexString(switchStrategy.getPercent(),1));
                        }
                        if((Integer)switchStrategy. getIntervalType() == null){//隔杆模式为空
                            //默认全亮
                            sb.append(RzIotConcentratorConstParam.POLE_MODEL_ALL);
                        }else{//隔杆模式不为空
                            sb.append(RzIotDigit.intToHexString(switchStrategy.getIntervalType(),1));
                        }
                        //隔杆控制集合
                        List<Pole> poleList = switchStrategy.getPoleList();
                        for(Pole pole : poleList ){
                            sb.append(RzIotDigit.intToHexString(pole.getStatus(),1));
                        }
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getSwitchNo(),2));
                    }
                }
                if(strategyType == RzIotConcentratorConstParam.CYCLE_TYPE_LONGITUDE_AND_LATITUDE){//经纬度
                    // 数据长度
                    sb.append(RzIotDigit.intToHexString(switchStrategies.size() * 280, 2));
                    for (ConcentratorSwitchStrategy switchStrategy : switchStrategies) {
                        sb.append(RzIotDigit.intToHexString(RzIotConcentratorConstParam.CYCLE_TYPE_LONGITUDE_AND_LATITUDE,1));
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getNo(),1));
                        //起始日期
                        Map<String, Integer> startDateMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartDate());
                        sb.append(RzIotDigit.intToHexString((Integer)startDateMap.get("day"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startDateMap.get("month"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startDateMap.get("year"), 1));
                        //结束日期
                        Map<String, Integer> endDateMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndDate());
                        sb.append(RzIotDigit.intToHexString((Integer)endDateMap.get("day"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endDateMap.get("month"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endDateMap.get("year"), 1));
                        //开灯时间
                        Map<String, Integer> startTimeMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartTime());
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("second"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("minute"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)startTimeMap.get("hour"), 1));
                        //关灯时间
                        Map<String, Integer> endTimeMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndTime());
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("second"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("minute"), 1));
                        sb.append(RzIotDigit.intToHexString((Integer)endTimeMap.get("hour"), 1));
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getOffset(),1));
                        if(switchStrategy.getStartMoveLight() == null){//调光开始时间为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{
                            //调光开始时间
                            Map<String, Integer> startMoveLightMap = MqttDateTimeUtils.DateToEach(switchStrategy.getStartMoveLight());
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("second"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("minute"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)startMoveLightMap.get("hour"), 1));
                        }
                        if(switchStrategy.getEndMoveLight() == null){//调光结束时间为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{
                            //调光结束时间
                            Map<String, Integer> endMoveLightMap = MqttDateTimeUtils.DateToEach(switchStrategy.getEndMoveLight());
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("second"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("minute"), 1));
                            sb.append(RzIotDigit.intToHexString((Integer)endMoveLightMap.get("hour"), 1));
                        }
                        if((Integer)switchStrategy.getPercent() == null){//调光百分比为空
                            sb.append(RzIotDigit.intToHexString(0,1));
                        }else{//调光百分比不为空
                            sb.append(RzIotDigit.intToHexString(switchStrategy.getPercent(),1));
                        }
                        if((Integer)switchStrategy. getIntervalType() == null){//隔杆模式为空
                            //默认全亮
                            sb.append(RzIotConcentratorConstParam.POLE_MODEL_ALL);
                        }else{//隔杆模式不为空
                            sb.append(RzIotDigit.intToHexString(switchStrategy.getIntervalType(),1));
                        }
                        List<Pole> poleList = switchStrategy.getPoleList();
                        for(Pole pole : poleList){
                            sb.append(RzIotDigit.intToHexString(pole.getStatus(),1));
                        }
                        sb.append(RzIotDigit.intToHexString(switchStrategy.getOutTag(),2));
                    }
                }

                break;
            case RzIotConcentratorConstParam.PUBLISH_TIMING:
                // 校时命令下发
                Map<String, Integer> datetime = RzIotDatetime.timestampToDateTime(RzIotDatetime.getTimestamp());
                sb.append(RzIotDigit.intToHexString(7, 2));
                sb.append(RzIotDigit.intToHexString((Integer)datetime.get("second"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)datetime.get("minute"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)datetime.get("hour"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)datetime.get("week"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)datetime.get("day"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)datetime.get("month"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)datetime.get("year"), 1));
                break;
            case RzIotConcentratorConstParam.PUBLISH_ENERGY_REPORT_TIME:
                // 电量定时上报时间下发
                ConcentratorElectricTimingReportTimePublish concentratorElectricTimingReportTimePublish = (ConcentratorElectricTimingReportTimePublish)this.object;
                Map<String, Integer> reportDate = MqttDateTimeUtils.DateToEach(concentratorElectricTimingReportTimePublish.getReportDate());
                sb.append(RzIotDigit.intToHexString(3, 2));
                sb.append(RzIotDigit.intToHexString((Integer)reportDate.get("second"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)reportDate.get("minute"), 1));
                sb.append(RzIotDigit.intToHexString((Integer)reportDate.get("hour"), 1));
                break;
            case RzIotConcentratorConstParam.PUBLISH_REMOTE_UPGRADE:
                // 服务端升级指令下发
                break;
        }
        return sb.toString();
    }

    // 解码
    public void decode(byte[] data) {
//        if (data.length < 16)
//            return false;

        // 操作码
        operateCode = RzIotDigit.getUnInt(data, 0);
        // 加密标志
        encryptType = RzIotDigit.getInt8(data, 1);
        // 消息ID
        msgId = RzIotDigit.getUnInt16(data, 2);
        // 时间戳
        timestamp = RzIotDigit.getHighUnInt32(data, 4);
        // 集中器序列号
        serialNo = RzIotString.getStringFromByteArray(data, 8, 16);
        // 数据长度
        length = RzIotDigit.getUnInt16(data, 24);
        // 消息头长度
        int offset = RzIotConcentratorConstParam.DATA_HEAD_LENGTH;
        switch (operateCode) {
            case RzIotConcentratorConstParam.REPORT_OF_FAULT:
                // 告警数据上报
                List<ConcentratorFaultReport> concentratorFaultReports = new ArrayList<>();

                final int numBytesPerPacket = 4;
                for (int i = 0; i + numBytesPerPacket <= length; i += numBytesPerPacket) {

                    Integer faultSource = RzIotDigit.getUnInt(data, offset + i);
                    Integer faultNumber = RzIotDigit.getUnInt(data, offset + i + 1);
                    Integer faultContent = RzIotDigit.getUnInt(data, offset + i + 2);
                    Integer faultValue = RzIotDigit.getUnInt(data, offset + i + 3);
                    byte[] faultData = Arrays.copyOfRange(data,offset + i, offset + i + 4);
                    String faultInfo = RzIotDigit.bytes2HexString(faultData);

                    ConcentratorFaultReport concentratorFaultReport = new ConcentratorFaultReport(faultData, faultInfo, faultSource, faultNumber, faultContent, faultValue);
                    concentratorFaultReports.add(concentratorFaultReport);
                }

                object = concentratorFaultReports;

                break;
            case RzIotConcentratorConstParam.REPORT_OF_SWITCH_STATUS:
                // 输出（开关）状态上报

                List<ConcentratorLineOutReport> concentratorLineOutReports = new ArrayList<>();
                int lineOuts = (length - offset) >> 2;

                for (int i = 0; i < lineOuts; ++i) {

                    int source = RzIotDigit.getUnInt(data, offset + i * 4);
                    int number = RzIotDigit.getUnInt(data, offset + i * 4 + 1);
                    int status = RzIotDigit.getUnInt(data, offset + i * 4 + 3);
                    ConcentratorLineOutReport concentratorLineOutReport = new ConcentratorLineOutReport(source, number, status);
                    concentratorLineOutReports.add(concentratorLineOutReport);
                }

                object = concentratorLineOutReports;
                break;
            case RzIotConcentratorConstParam.REPORT_OF_ELECTRIC_PARAM:
                // 电气参数上报

                ConcentratorElectricParamReport electricParamReport = new ConcentratorElectricParamReport();
                electricParamReport.setParam(data, offset, length);
                object = electricParamReport;

                break;
            case RzIotConcentratorConstParam.REPORT_OF_FAULT_PARAM:
                // 告警参数上报
                ConcentratorFaultParamReport concentratorFaultParamReport = new ConcentratorFaultParamReport();
                concentratorFaultParamReport.setParam(data, offset, length);

                break;
            case RzIotConcentratorConstParam.REPORT_OF_CONFIG_PARAM:
                // 配置参数上报

                ConcentratorConfigParamReport concentratorConfigParamReport = new ConcentratorConfigParamReport();
                concentratorConfigParamReport.setParam(data, offset, length);

                object = concentratorConfigParamReport;

                break;
            case RzIotConcentratorConstParam.REPORT_OF_CURRENT_TIME:
                // 当前时间上报
                ConcentratorDateTimeReport concentratorDateTimeReport = new ConcentratorDateTimeReport();
                concentratorDateTimeReport.setParam(data, offset, length);
                object = concentratorDateTimeReport;

                break;
            case RzIotConcentratorConstParam.REPORT_OF_SWITCH_STRATEGY:
                // 开关策略（预约方案）上报
                ConcentratorAppointParamReport concentratorAppointParamReport = new ConcentratorAppointParamReport();
                concentratorAppointParamReport.setParam(data, offset, length);
                object = concentratorAppointParamReport;

                break;
            case RzIotConcentratorConstParam.REPORT_OF_ENERGY:
                // RTU电量上报

                ConcentratorElectricQuantityReport concentratorElectricQuantityReport = new ConcentratorElectricQuantityReport();
                concentratorElectricQuantityReport.setParam(data, offset, length);
                break;
            case RzIotConcentratorConstParam.REPORT_OF_ENVIRONMENT_PARAM:
                // RTU环境参数上报
                ConcenterEnvironmentParameterReport concenterEnvironmentParameterReport = new ConcenterEnvironmentParameterReport();
                concenterEnvironmentParameterReport.setParam(data, offset, length);
                object = concenterEnvironmentParameterReport;

                break;

            case RzIotConcentratorConstParam.REPORT_OF_HEARTBEAT_AND_SIGNAL_STRENGTH:
                // 心跳 && 信号强度上报
                // 信号强度
                int signalStrength = RzIotDigit.getInt8(data, offset);
                ConcentratorHeartbeatReport concentratorHeartbeatReport = new ConcentratorHeartbeatReport();
                concentratorHeartbeatReport.setSignalStrength(signalStrength);
                object = concentratorHeartbeatReport;

                break;

            case RzIotConcentratorConstParam.REPORT_OF_AUTH:
                // 身份认证上报
                String username = RzIotString.getStringFromByteArray(data, offset, 4);
                // 密码非标准形式（需要将16进制转换成10进制）
                String password = Integer.parseInt(RzIotDigit.bytes2HexString(Arrays.copyOfRange(data, offset + 4, data.length)), 16) + "";
                ConcentratorAuthReport concentratorAuthReport = new ConcentratorAuthReport();
                concentratorAuthReport.setUsername(username);
                concentratorAuthReport.setPassword(password);
                object = concentratorAuthReport;

                break;

            case RzIotConcentratorConstParam.REPORT_OF_REMOTE_UPGRADE:
                // 升级步骤上报
                int tag = RzIotDigit.getInt8(data, offset + 1);

                CountDownLatch countDownLatch = ConcentratorPublishServiceImpl.cdlMap.get(this.serialNo);
                switch (tag) {
                    case 0x80:
                        // 一、握手
                        countDownLatch.countDown();
                        break;
                    case 0x81:
                        // 二、擦除
                        countDownLatch.countDown();
                        break;
                    case 0x82:
                        // 三、传输
                        countDownLatch.countDown();
                        break;
                    case 0x83:
                        // 四、结束
                        countDownLatch.countDown();
                        break;
                    case 0x84:
                        // 五、重启
                        countDownLatch.countDown();
                        break;

                }
        }
    }
}