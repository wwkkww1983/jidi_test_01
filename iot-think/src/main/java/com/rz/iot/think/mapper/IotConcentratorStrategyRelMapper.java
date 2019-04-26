package com.rz.iot.think.mapper;

import com.rz.iot.think.model.*;
import com.rz.iot.think.model.show.IotBindConStraShow;
import com.rz.iot.think.model.show.IotConcentratorShowList;
import com.rz.iot.think.model.show.IotSwitchBrightnessShowDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotConcentratorStrategyRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorStrategyRel record);

    int insertSelective(IotConcentratorStrategyRel record);

    IotConcentratorStrategyRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorStrategyRel record);

    int updateByPrimaryKey(IotConcentratorStrategyRel record);

    //开关绑定集中器(组)
    void bindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator);

    //开关取消绑定集中器(组)
    void unbindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator);

    //根据开关策略查询集中器
    List<IotConcentratorStrategyRel> selectBySwitchId(@Param("switchId") Integer switchId);


    //删除所有关联开关策略的开关策略集中器关联表
    void deleteList(List<IotConcentratorStrategyRel> list);

    /**
     * 根据集中器id集中器类型（是否是集中器组）查询集中器策略关联关系（一个集中器（组）只与一条策略关联）
     * @param concentratorId 集中器id
     * @param concentratorType 集中器类型 1：集中器；2：集中器组
     * @return
     */
    IotConcentratorStrategyRel findByConcentratorId(@Param("concentratorId") Integer concentratorId, @Param("concentratorType") Integer concentratorType);

    /**
     * 查询所有与开关策略绑定的集中器
     * @param userId
     * @return
     */
    List<IotBindConStraShow> findBindConStrategy(@Param("userId")  Integer userId);


    /**
     * 查询与开关策略绑定的集中器组
     * @param id
     * @return
     */
    List<IotBindConStraShow> findBindConGroupStrategy(Integer id);

}