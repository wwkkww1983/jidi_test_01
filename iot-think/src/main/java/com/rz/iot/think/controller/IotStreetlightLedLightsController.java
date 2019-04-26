package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotStreetlightLedLightsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/led")
public class IotStreetlightLedLightsController {

    @Resource
    private IotStreetlightLedLightsService iotStreetlightLedLightsService;

    /**
     * led详情
     * @param ledId led id
     * @return
     */
    @RequestMapping("/detail")
    public Result detail(Integer ledId) {
        return iotStreetlightLedLightsService.detail(ledId);
    }
}
