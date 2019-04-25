package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotStreetlightInstallDevRelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/3/21.
 * PS: Not easy to write code, please indicate.
 * Description：挂载设备controller
 */
@RestController
@RequestMapping("/installDev")
public class IotStreetlightInstallDevController {

    @Resource
    private IotStreetlightInstallDevRelService iotStreetlightInstallDevRelService;

    /**
     * 查找未与路灯绑定的挂载设备
     * @param devType 挂载设备类型，1：摄像头；2：显示屏；3：WiFi；4：环境传感器
     * @return
     */
    @RequestMapping("/findNoBinding")
    public Result findNoBinding(Integer devType) {
        return iotStreetlightInstallDevRelService.findNoBinding(devType);
    }

    /**
     * 挂载设备详情
     * @param devId 挂载设备id
     * @param devType 挂载设备类型，1：摄像头；2：显示屏；3：WiFi；4：环境传感器；5：广播/紧急求助；6：充电桩
     * @return
     */
    @RequestMapping("/detail")
    public Result detail(Integer devId, Integer devType) {
        return iotStreetlightInstallDevRelService.detail(devId, devType);
    }
}
