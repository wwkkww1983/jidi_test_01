package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;

import java.util.HashMap;
import java.util.List;

public interface IotStreetlightInstallDevRelService {

    /**
     * 通过路灯id获取设备信息列表
     * @param StreetlightId 路灯id
     * @return 返回设备列表
     */
    List<HashMap> getDevByStreetlightId(Integer StreetlightId);

    /**
     * 查找未与路灯绑定的挂载设备
     * @param devType 挂载设备类型，1：摄像头；2：显示屏；3：WiFi；4：环境传感器
     * @return
     */
    Result findNoBinding(Integer devType);

    /**
     * 挂载设备详情
     * @param devId 挂载设备id
     * @param devType 挂载设备类型，1：摄像头；2：显示屏；3：WiFi；4：环境传感器；5：广播/紧急求助；6：充电桩
     * @return
     */
    Result detail(Integer devId, Integer devType);
}
