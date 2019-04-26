package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotConcentratorBrightnessStrategyMapper;
import com.rz.iot.think.model.IotConcentratorBrightnessStrategy;
import com.rz.iot.think.service.IotConcentratorBrightnessStrategyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
@Service
@Transactional
public class IotConcentratorBrightnessStrategyServiceImpl implements IotConcentratorBrightnessStrategyService {
    @Resource
    private IotConcentratorBrightnessStrategyMapper mapper;


    @Override
    public List<Integer> insertIotConcentratorBrightnessStrategys(List<IotConcentratorBrightnessStrategy> iotConcentratorBrightnessStrategy) {
        if(iotConcentratorBrightnessStrategy.size() != 0 && iotConcentratorBrightnessStrategy != null){
            //说明添加了调光策略
            mapper.insertIotConcentratorBrightnessStrategys(iotConcentratorBrightnessStrategy);

            //获取最新插入的调光策略id集合
            List<Integer> ids =  mapper.findLast(iotConcentratorBrightnessStrategy.size());
            return ids;
        }

        return null;

    }

    @Override
    public void deleteIotConcentratorBrightnessStrategy(IotConcentratorBrightnessStrategy iotConcentratorBrightnessStrategy) {
        if(iotConcentratorBrightnessStrategy != null){
            mapper.deleteByPrimaryKey(iotConcentratorBrightnessStrategy.getId());
        }
    }
}
