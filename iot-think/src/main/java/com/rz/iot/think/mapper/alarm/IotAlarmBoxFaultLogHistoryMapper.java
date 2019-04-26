package com.rz.iot.think.mapper.alarm;

import com.rz.iot.think.model.alarm.IotAlarmBoxFaultLogHistory;

public interface IotAlarmBoxFaultLogHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAlarmBoxFaultLogHistory record);

    int insertSelective(IotAlarmBoxFaultLogHistory record);

    IotAlarmBoxFaultLogHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAlarmBoxFaultLogHistory record);

    int updateByPrimaryKey(IotAlarmBoxFaultLogHistory record);
}