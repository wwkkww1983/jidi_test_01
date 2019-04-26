package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenPlayStrategyCommandRel;
import com.rz.iot.think.model.show.IotScreenShowSendStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotScreenPlayStrategyCommandRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenPlayStrategyCommandRel record);

    int insertSelective(IotScreenPlayStrategyCommandRel record);

    IotScreenPlayStrategyCommandRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenPlayStrategyCommandRel record);

    int updateByPrimaryKey(IotScreenPlayStrategyCommandRel record);

    /**
     * 根据策略id查找信息屏
     * @param playStrategyId 策略id
     * @return
     */
    List<IotScreenShowSendStatus> findScreenByStrategyId(Integer playStrategyId);

    /**
     * 根据策略id、屏幕id查找记录
     * @param strategyId
     * @param screenId
     * @return
     */
    IotScreenPlayStrategyCommandRel findByStrategyIdAndScreenId(@Param("strategyId") Integer strategyId, @Param("screenId") Integer screenId);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotScreenPlayStrategyCommandRel> list);

    /**
     * 根据策略id删除记录
     * @param strategyId
     */
    void delByStrategyId(Integer strategyId);

    /**
     * 根据指令编号查找记录
     * @param commandNo 指令编号
     * @return
     */
    List<IotScreenPlayStrategyCommandRel> findByCommandNo(String commandNo);
}