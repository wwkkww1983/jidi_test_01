package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotAreaInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/4/3.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@RestController
@RequestMapping("/areaInfo")
public class IotAreaInfoController {

    @Resource
    private IotAreaInfoService iotAreaInfoService;

    /**
     * 查询所有的省
     * @return
     */
    @RequestMapping("/findAllProvince")
    public Result findAllProvince() {
        return iotAreaInfoService.findAllProvince();
    }

    /**
     * 根据省查询所有的市
     * @param provinceId 省id
     * @return
     */
    @RequestMapping("/findCityByProvinceId")
    public Result findCityByProvinceId(Integer provinceId) {
        return iotAreaInfoService.findCityByProvinceId(provinceId);
    }

    /**
     * 根据市查询所有的区
     * @param cityId 市id
     * @return
     */
    @RequestMapping("/findDistrictByCityId")
    public Result findDistrictByCityId(Integer cityId) {
        return iotAreaInfoService.findDistrictByCityId(cityId);
    }
}
