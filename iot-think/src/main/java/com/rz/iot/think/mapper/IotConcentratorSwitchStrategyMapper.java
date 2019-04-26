package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentrator;
import com.rz.iot.think.model.IotConcentratorGroup;
import com.rz.iot.think.model.IotConcentratorSwitchStrategy;
import com.rz.iot.think.model.show.IotBindConStraShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IotConcentratorSwitchStrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorSwitchStrategy record);

    int insertSelective(IotConcentratorSwitchStrategy record);

    IotConcentratorSwitchStrategy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorSwitchStrategy record);

    int updateByPrimaryKey(IotConcentratorSwitchStrategy record);

    /**
     * 查询所有开关策略
     * @param iotConcentratorSwitchStrategy
     * @param userId
     * @return
     */
    List<IotConcentratorSwitchStrategy> findIotConcentratorSwitchStrategyList(@Param("iotConcentratorSwitchStrategy") IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy,@Param("userId") Integer userId);

    /**
     * 查找最新查看的开关策略
     * @return
     */
    IotConcentratorSwitchStrategy findLast();

    void deleteByPrimaryKeys(List<Integer> id);

    /**
     * 通过集中器的id查询对应的策略
     * @param concentratorId
     * @return
     */
    IotConcentratorSwitchStrategy findSwitchStrategyByConcentratorId(@Param("concentratorId") Integer concentratorId,@Param("userId") Integer userId);

    /**
     * 通过策略id查询开关策略
     * @param id
     * @param userId
     * @return
     */
    IotConcentratorSwitchStrategy findIotConcentratorSwitchStrategy(@Param("id") Integer id,@Param("userId") Integer userId);


    /**
     * 通过集中器组的id查询对应的策略
     * @param concentratorGroupId
     * @param id1
     * @return
     */
    IotConcentratorSwitchStrategy findSwitchStrategyByConcentratorGroupId(@Param("concentratorGroupId") Integer concentratorGroupId,@Param("userId") Integer id1);

    /**
     * 查询出未绑定的集中器
     * @return
     * @param userId 当前操作用户的id
     */
    List<IotConcentrator> findUnbindConcentrator(@Param("userId") Integer userId);

    /**
     * 查询出未绑定的集中器组
     * @param userId 当前操作用户的id
     * @return
     */
    List<IotConcentratorGroup> findUnbindConcentratorGroup(@Param("userId") Integer userId);
}