package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenPlayStrategyRel;

import java.util.List;

public interface IotScreenPlayStrategyRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenPlayStrategyRel record);

    int insertSelective(IotScreenPlayStrategyRel record);

    IotScreenPlayStrategyRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenPlayStrategyRel record);

    int updateByPrimaryKey(IotScreenPlayStrategyRel record);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotScreenPlayStrategyRel> list);

    /**
     * 根据策略id查询记录
     * @param strategyId
     * @return
     */
    List<IotScreenPlayStrategyRel> findByStrategyId(Integer strategyId);

    /**
     * 根据策略id删除记录
     * @param strategyId 策略id
     */
    void delByStrategyId(Integer strategyId);
}