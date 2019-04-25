package com.rz.iot.think.mapper.alarm;

import com.rz.iot.think.model.alarm.IotAlarmBoxFaultLog;

public interface IotAlarmBoxFaultLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAlarmBoxFaultLog record);

    int insertSelective(IotAlarmBoxFaultLog record);

    IotAlarmBoxFaultLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAlarmBoxFaultLog record);

    int updateByPrimaryKey(IotAlarmBoxFaultLog record);
}