package com.rz.iot.think.controller;

import com.rz.iot.think.model.IotConcentratorPower;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotPowerParam;
import com.rz.iot.think.model.show.ShowIotPower;
import com.rz.iot.think.service.IotPowerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 集中器用电量管理
 *
 * @author rycony
 * @created 2019/3/21 0021.
 */
@RestController
@RequestMapping("/iotPower")
public class IotPowerController {
    @Resource
    private IotPowerService iotPowerService;

    /**
     * 根据条件参数查询用电量情况
     * @param iotPowerParam 集中器相关参数
     * @return
     */
    @RequestMapping("/findConcentratorPowers")
    public Result findConcentratorPowers(IotPowerParam iotPowerParam,Page<ShowIotPower> page){
        return iotPowerService.findList(iotPowerParam,page);
    }
}
