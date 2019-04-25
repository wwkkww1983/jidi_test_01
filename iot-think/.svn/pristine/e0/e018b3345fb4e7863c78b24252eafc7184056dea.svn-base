package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotConcentratorSwitchBrightnessStrategyRelMapper;
import com.rz.iot.think.model.IotConcentratorSwitchStrategy;
import com.rz.iot.think.service.IotConcentratorSwitchBrightnessStrategyRelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
@Service
@Transactional
public class IotConcentratorSwitchBrightnessStrategyRelServiceImpl implements IotConcentratorSwitchBrightnessStrategyRelService {
    @Resource
    private IotConcentratorSwitchBrightnessStrategyRelMapper mapper;

    @Override
    public void insertIotConcentratorSwitchBrightnessStrategyRel(int findLast, List<Integer> ids) {
        mapper.insertIotConcentratorSwitchBrightnessStrategyRel(findLast,ids);
    }
}
