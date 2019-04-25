package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotBuilder;

public interface IotBuilderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotBuilder record);

    int insertSelective(IotBuilder record);

    IotBuilder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotBuilder record);

    int updateByPrimaryKey(IotBuilder record);

    /**
     * 假删除
     * @param builderId 建造商id
     */
    void fakeDelete(Integer builderId);
}