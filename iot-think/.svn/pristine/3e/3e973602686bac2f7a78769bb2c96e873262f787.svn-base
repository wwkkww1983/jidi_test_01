package com.rz.iot.think.service;

import com.rz.iot.think.model.IotConcentratorSwitchStrategy;
import com.rz.iot.think.model.IotSwitchBindConcentrator;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.IotSwitchBrightnessShowDetail;

import java.util.List;

/**
 * Created by Administrator on 2019/3/12 0012.
 */
public interface IotConcentratorSwitchStrategyService {
    //插入开关策略
    public IotConcentratorSwitchStrategy insertIotConcentratorSwitchStrategy(IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy);

    //根据id查找开关策略
    public Result findIotConcentratorSwitchStrategy(Integer id);

    //查询所有的开关策略
    public Result findIotConcentratorSwitchStrategyList(IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy,Page<IotConcentratorSwitchStrategy> page);

    //编辑
    public Result editIotConcentratorSwitchStrategy(IotSwitchBrightnessShowDetail iotSwitchBrightnessShowDetail);

    //删除
    public Result delete(List<Integer> id);

    //绑定集中器(组)
    public Result bindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator);

    //解除绑定集中器(组)
    public Result unbindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator);

    //重新发送开关策略到集中器
    public Result resendSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator);

    //批量打开集中器开关
    public Result openOrCloseConcentrators(IotSwitchBindConcentrator iotSwitchBindConcentrator);

    //根据开关策略id查询出
    public Result findIotSwitchStrategyShowDetail(Integer id);

    //根据调光还有集中器id进行调光
    public Result brightConcentrators(IotSwitchBindConcentrator iotSwitchBindConcentrator);

    //查询出未绑定的集中器(组)
    public Result findUnbindConcentrator(Integer concentratorType);
}
