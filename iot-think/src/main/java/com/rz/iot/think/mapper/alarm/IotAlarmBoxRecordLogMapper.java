package com.rz.iot.think.mapper.alarm;

import com.rz.iot.think.model.alarm.IotAlarmBoxRecordLog;

public interface IotAlarmBoxRecordLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAlarmBoxRecordLog record);

    int insertSelective(IotAlarmBoxRecordLog record);

    IotAlarmBoxRecordLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAlarmBoxRecordLog record);

    int updateByPrimaryKey(IotAlarmBoxRecordLog record);

    //查询数据库中最近的一条产生报警记录
    IotAlarmBoxRecordLog findIotAlarmBoxRecordLogProduce();

    //查询数据库最近的一条恢复报警记录
    IotAlarmBoxRecordLog findIotAlarmBoxRecordLogDisappear();
}