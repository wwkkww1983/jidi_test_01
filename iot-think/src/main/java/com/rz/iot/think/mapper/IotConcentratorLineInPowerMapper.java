package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorLineInPower;

public interface IotConcentratorLineInPowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorLineInPower record);

    int insertSelective(IotConcentratorLineInPower record);

    IotConcentratorLineInPower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorLineInPower record);

    int updateByPrimaryKey(IotConcentratorLineInPower record);

    /**
     * 根据进线id查找
     * @param lineInId 进线id
     * @return
     */
    IotConcentratorLineInPower findByLineInId(Integer lineInId);
}