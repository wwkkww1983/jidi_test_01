package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorLineIn;
import com.rz.iot.think.model.show.IotConcentratorLineInInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotConcentratorLineInMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorLineIn record);

    int insertSelective(IotConcentratorLineIn record);

    IotConcentratorLineIn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorLineIn record);

    int updateByPrimaryKey(IotConcentratorLineIn record);

    /**
     * 根据集中器id查找输入
     * @param concentratorId 集中器id
     * @return
     */
    List<IotConcentratorLineInInfo> findByConcentratorId(Integer concentratorId);

    /**
     * 批量插入进线信息
     * @param lineInList 进线信息列表
     * @return 返回插入成功条数
     */
    Integer batchInsert(List<IotConcentratorLineIn> lineInList);

    /**
     * 根据集中器id假删除进线信息
     * @param concentratorId 集中器id
     */
    void fakeDelete(Integer concentratorId);

    /**
     * 根据进线类型查找
     * @param type 进线类型 1：A相；2：B相；3：C相；4：合相
     * @param concentratorId 集中器id
     * @return
     */
    IotConcentratorLineIn findByLineInType(@Param("type") Integer type, @Param("concentratorId") Integer concentratorId);
}