package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenWeatherSource;

public interface IotScreenWeatherSourceMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(IotScreenWeatherSource record);

    int insertSelective(IotScreenWeatherSource record);

    IotScreenWeatherSource selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(IotScreenWeatherSource record);

    int updateByPrimaryKey(IotScreenWeatherSource record);

    /**
     * 根据节目id删除布局
     * @param programId 节目id
     */
    void delByProgramId(Integer programId);
}