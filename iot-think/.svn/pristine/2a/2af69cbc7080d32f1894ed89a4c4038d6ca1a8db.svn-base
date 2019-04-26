package com.rz.iot.think.service;

import com.rz.iot.think.model.alarm.IotAlarmBoxRecordLog;

/**
 * @Author:jidi
 * @Date:2019/04/22 17:40
 * @Description:报警箱报警日志记录
 **/
public interface IotAlarmBoxRecordLogService {

    /***
     * 增加一条记录
     * @param iotAlarmBoxRecordLog
     * @return
     */
    int addIotAlarmBoxRecorderLog(IotAlarmBoxRecordLog iotAlarmBoxRecordLog);

    /***
     * 查询出最近的一条产生报警信息记录
     * @return
     */
    IotAlarmBoxRecordLog  findIotAlarmBoxRecordLogProduce();

    /***
     * 查询最近的一条恢复报警信息记录
     * @return
     */
    IotAlarmBoxRecordLog findIotAlarmBoxRecordLogDisappear();


}
