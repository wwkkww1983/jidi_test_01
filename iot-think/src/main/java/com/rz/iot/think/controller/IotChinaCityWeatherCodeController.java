package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotChinaCityWeatherCodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/4/10.
 * PS: Not easy to write code, please indicate.
 * Description：城市天气代码查询
 */
@RestController
@RequestMapping("/weatherCode")
public class IotChinaCityWeatherCodeController {

    @Resource
    private IotChinaCityWeatherCodeService iotChinaCityWeatherCodeService;

    /**
     * 城市天气代码模糊查询
     * @param key 关键字
     * @return
     */
    @RequestMapping("/search")
    public Result search(String key) {
        return iotChinaCityWeatherCodeService.search(key);
    }
}
