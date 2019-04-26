package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.alarm.IotAlarmBoxRecord;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderStatusUpdateParam;

/**
 * @Author:jidi
 * @Date:2019/04/11 15:50
 * @Description:报警信息记录操作接口
 **/
public interface IotAlarmBoxRecordService {

    /***
     * 根据主键修改报警信息记录状态
     * @param iotAlarmBoxRecorderStatusUpdateParam
     * @return
     */
    Result updateStatusById(IotAlarmBoxRecorderStatusUpdateParam iotAlarmBoxRecorderStatusUpdateParam);


    /***
     * 根据报警箱id查询报警箱实时报警记录
     * @param boxId
     * @return
     */
    IotAlarmBoxRecord findIotAlarmBoxRecord(int boxId);

    /***
     * 增加一条记录
     * @param iotAlarmBoxRecord
     * @return
     */
    int addIotAlarmBoxRecord(IotAlarmBoxRecord iotAlarmBoxRecord);

    /***
     * 修改报警箱实时报警信息记录表记录
     * @param iotAlarmBoxRecord
     * @return
     */
    int updateIotAlarmBoxRecord(IotAlarmBoxRecord iotAlarmBoxRecord);
}
