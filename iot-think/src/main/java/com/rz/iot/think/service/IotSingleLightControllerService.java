package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;

import java.util.HashMap;
import java.util.List;

public interface IotSingleLightControllerService {
    List<HashMap> getSlcByIds(List<Integer> ids);

    /**
     * 单灯控制器详细信息
     * @param slcId 单灯控制器id
     * @return
     */
    Result detail(Integer slcId);
}
