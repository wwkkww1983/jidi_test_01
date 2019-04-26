package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorBrightnessStrategy;
import com.rz.iot.think.model.IotConcentratorSwitchBrightnessStrategyRel;
import com.rz.iot.think.model.IotConcentratorSwitchStrategy;
import com.rz.iot.think.model.IotSwitchBindConcentrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IotConcentratorSwitchBrightnessStrategyRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorSwitchBrightnessStrategyRel record);

    int insertSelective(IotConcentratorSwitchBrightnessStrategyRel record);

    IotConcentratorSwitchBrightnessStrategyRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorSwitchBrightnessStrategyRel record);

    int updateByPrimaryKey(IotConcentratorSwitchBrightnessStrategyRel record);

    void insertIotConcentratorSwitchBrightnessStrategyRel(@Param("switchId") int switchId, @Param("ids") List<Integer> ids);

    //根据id查询出调光策略详情
    List<IotConcentratorBrightnessStrategy> findIotSwitchStrategyShowDetail(Integer id);


    //通过开关策略id查询出关联关系表
    public List<IotConcentratorSwitchBrightnessStrategyRel> findBySwitchId(Integer switchId);

    //通过开关id书暗处关联关系
    void deleteBySwitchId(@Param("switchIds") List<Integer> switchIds);
}