package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotSensor;
import com.rz.iot.think.model.show.IotStreetlightInstallDevForNoBinding;
import com.rz.iot.think.model.show.IotStreetlightInstallDevShowDetail;

import java.util.List;

public interface IotSensorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotSensor record);

    int insertSelective(IotSensor record);

    IotSensor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotSensor record);

    int updateByPrimaryKey(IotSensor record);

    /**
     * 查找未与路灯绑定的传感器
     * @return
     */
    List<IotStreetlightInstallDevForNoBinding> findNoBinding();

    /**
     *传感器详情（路灯管理）
     * @param sensorId 传感器id
     * @return
     */
    IotStreetlightInstallDevShowDetail detailForStreetLight(Integer sensorId);
}