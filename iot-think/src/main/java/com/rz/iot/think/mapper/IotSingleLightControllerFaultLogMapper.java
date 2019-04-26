package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotSingleLightControllerFaultLog;

public interface IotSingleLightControllerFaultLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotSingleLightControllerFaultLog record);

    int insertSelective(IotSingleLightControllerFaultLog record);

    IotSingleLightControllerFaultLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotSingleLightControllerFaultLog record);

    int updateByPrimaryKey(IotSingleLightControllerFaultLog record);
}