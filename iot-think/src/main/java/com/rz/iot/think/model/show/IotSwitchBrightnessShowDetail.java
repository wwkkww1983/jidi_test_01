package com.rz.iot.think.model.show;

import com.rz.iot.think.model.IotConcentratorBrightnessStrategy;
import com.rz.iot.think.model.IotConcentratorSwitchStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/14 0014.
 */
public class IotSwitchBrightnessShowDetail {
    private IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy;
    private List<IotConcentratorBrightnessStrategy> iotConcentratorBrightnessStrategyList = new ArrayList<IotConcentratorBrightnessStrategy>();

    public IotConcentratorSwitchStrategy getIotConcentratorSwitchStrategy() {
        return iotConcentratorSwitchStrategy;
    }

    public void setIotConcentratorSwitchStrategy(IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy) {
        this.iotConcentratorSwitchStrategy = iotConcentratorSwitchStrategy;
    }

    public List<IotConcentratorBrightnessStrategy> getIotConcentratorBrightnessStrategyList() {
        return iotConcentratorBrightnessStrategyList;
    }

    public void setIotConcentratorBrightnessStrategyList(List<IotConcentratorBrightnessStrategy> iotConcentratorBrightnessStrategyList) {
        this.iotConcentratorBrightnessStrategyList = iotConcentratorBrightnessStrategyList;
    }
}
