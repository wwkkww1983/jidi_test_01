package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorBrightnessStrategy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotConcentratorBrightnessStrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorBrightnessStrategy record);

    int insertSelective(IotConcentratorBrightnessStrategy record);

    IotConcentratorBrightnessStrategy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorBrightnessStrategy record);

    int updateByPrimaryKey(IotConcentratorBrightnessStrategy record);

    void insertIotConcentratorBrightnessStrategys(@Param("iotConcentratorBrightnessStrategy") List<IotConcentratorBrightnessStrategy> iotConcentratorBrightnessStrategy);

    List<Integer> findLast(int size);

    void deleteById(Integer brightnessId);
}