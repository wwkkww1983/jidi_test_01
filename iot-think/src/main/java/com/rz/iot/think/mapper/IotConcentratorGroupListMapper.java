package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorGroupList;

import java.util.List;

public interface IotConcentratorGroupListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorGroupList record);

    int insertSelective(IotConcentratorGroupList record);

    IotConcentratorGroupList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorGroupList record);

    int updateByPrimaryKey(IotConcentratorGroupList record);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotConcentratorGroupList> list);

    /**
     * 根据集中器组id删除
     * @param groupId
     */
    void delByGroupId(Integer groupId);
}