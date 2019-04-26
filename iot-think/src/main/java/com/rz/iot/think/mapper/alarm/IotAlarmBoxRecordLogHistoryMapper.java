package com.rz.iot.think.mapper.alarm;

import com.rz.iot.think.model.alarm.IotAlarmBoxRecordLogHistory;

public interface IotAlarmBoxRecordLogHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAlarmBoxRecordLogHistory record);

    int insertSelective(IotAlarmBoxRecordLogHistory record);

    IotAlarmBoxRecordLogHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAlarmBoxRecordLogHistory record);

    int updateByPrimaryKey(IotAlarmBoxRecordLogHistory record);
}