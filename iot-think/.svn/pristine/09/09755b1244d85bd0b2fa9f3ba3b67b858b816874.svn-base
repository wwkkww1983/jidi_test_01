package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;

/**
 * Author by xuxiake, Date on 2019/4/3.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotAreaInfoService {

    /**
     * 查询所有的省
     * @return
     */
    Result findAllProvince();

    /**
     * 根据省查询所有的市
     * @param provinceId 省id
     * @return
     */
    Result findCityByProvinceId(Integer provinceId);

    /**
     * 根据市查询所有的区
     * @param cityId 市id
     * @return
     */
    Result findDistrictByCityId(Integer cityId);
}
