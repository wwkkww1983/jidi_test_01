package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorFault;

public interface IotConcentratorFaultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorFault record);

    int insertSelective(IotConcentratorFault record);

    IotConcentratorFault selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorFault record);

    int updateByPrimaryKey(IotConcentratorFault record);

    /**
     * 根据类型与集中器id查找
     * @param type 类型
     * @param concentratorId 集中器id
     * @return
     */
    IotConcentratorFault findByType(String type, Integer concentratorId);
}