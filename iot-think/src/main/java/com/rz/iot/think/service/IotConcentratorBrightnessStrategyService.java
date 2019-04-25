package com.rz.iot.think.service;

import com.rz.iot.think.model.IotConcentratorBrightnessStrategy;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
public interface IotConcentratorBrightnessStrategyService {
    //新增调光策略
    public List<Integer> insertIotConcentratorBrightnessStrategys(List<IotConcentratorBrightnessStrategy> iotConcentratorBrightnessStrategy);


    //删除调光策略
    public void deleteIotConcentratorBrightnessStrategy(IotConcentratorBrightnessStrategy iotConcentratorBrightnessStrategy);
}
