package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotAreaCityRoadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@RestController
@RequestMapping("/road")
public class IotAreaCityRoadController {

    @Resource
    private IotAreaCityRoadService iotAreaCityRoadService;

    /**
     * 根据区id查找路
     * @param districtId 区id
     * @return
     */
    @RequestMapping("/findByDistrictId")
    public Result findByDistrictId(Integer districtId) {
        return iotAreaCityRoadService.findByDistrictId(districtId);
    }
}
