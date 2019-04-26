package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;

public interface IotStreetlightLedLightsService {

    /**
     * led详情
     * @param ledId led id
     * @return
     */
    Result detail(Integer ledId);
}
