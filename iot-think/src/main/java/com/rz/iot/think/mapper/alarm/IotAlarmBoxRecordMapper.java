package com.rz.iot.think.mapper.alarm;

import com.rz.iot.think.model.alarm.IotAlarmBoxRecord;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderStatusUpdateParam;

public interface IotAlarmBoxRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAlarmBoxRecord record);

    int insertSelective(IotAlarmBoxRecord record);

    IotAlarmBoxRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAlarmBoxRecord record);

    int updateByPrimaryKey(IotAlarmBoxRecord record);

    //根据主键修改报警信息记录状态
    int updateStatusById(IotAlarmBoxRecorderStatusUpdateParam iotAlarmBoxRecorderStatusUpdateParam);

    //根据boxId查询报警箱实时报警记录
    IotAlarmBoxRecord findIotAlarmBoxRecordByBoxId(Integer boxId);
}