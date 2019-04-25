package com.rz.iot.think.mapper.alarm;

import com.rz.iot.think.model.alarm.IotAlarmBoxFault;

public interface IotAlarmBoxFaultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAlarmBoxFault record);

    int insertSelective(IotAlarmBoxFault record);

    IotAlarmBoxFault selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAlarmBoxFault record);

    int updateByPrimaryKey(IotAlarmBoxFault record);
}