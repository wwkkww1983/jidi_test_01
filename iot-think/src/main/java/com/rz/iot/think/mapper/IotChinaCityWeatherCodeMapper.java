package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotChinaCityWeatherCode;

import java.util.List;

public interface IotChinaCityWeatherCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotChinaCityWeatherCode record);

    int insertSelective(IotChinaCityWeatherCode record);

    IotChinaCityWeatherCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotChinaCityWeatherCode record);

    int updateByPrimaryKey(IotChinaCityWeatherCode record);

    /**
     * 城市天气代码模糊查询
     * @param key 关键字
     * @return
     */
    List<IotChinaCityWeatherCode> search(String key);
}