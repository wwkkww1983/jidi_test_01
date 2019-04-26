package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotSingleLightControllerPower;

public interface IotSingleLightControllerPowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotSingleLightControllerPower record);

    int insertSelective(IotSingleLightControllerPower record);

    IotSingleLightControllerPower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotSingleLightControllerPower record);

    int updateByPrimaryKey(IotSingleLightControllerPower record);

    /**
     * 根据单灯控制器sn查找
     * @param slcSn 单灯控制器sn
     * @return
     */
    IotSingleLightControllerPower findBySlcSn(String slcSn);
}