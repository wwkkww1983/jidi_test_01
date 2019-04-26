package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorPower;

public interface IotConcentratorPowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorPower record);

    int insertSelective(IotConcentratorPower record);

    IotConcentratorPower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorPower record);

    int updateByPrimaryKey(IotConcentratorPower record);

    /**
     * 根据集中器id查找
     * @param concentratorId 集中器id
     * @return
     */
    IotConcentratorPower findByConcentratorId(Integer concentratorId);
}