package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;

/**
 * Author by xuxiake, Date on 2019/4/10.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotChinaCityWeatherCodeService {

    /**
     * 城市天气代码模糊查询
     * @param key 关键字
     * @return
     */
    Result search(String key);
}
