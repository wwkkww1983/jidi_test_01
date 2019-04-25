package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorLineOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotConcentratorLineOutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorLineOut record);

    int insertSelective(IotConcentratorLineOut record);

    IotConcentratorLineOut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorLineOut record);

    int updateByPrimaryKey(IotConcentratorLineOut record);

    /**
     * 根据集中器查找输出
     * @param concentratorId 集中器id
     * @return
     */
    List<IotConcentratorLineOut> findByConcentratorId(Integer concentratorId);

    /**
     * 批量插入出线信息
     * @param lineOutList 出线信息列表
     * @return 返回插入成功条数
     */
    Integer batchInsert(List<IotConcentratorLineOut> lineOutList);

    /**
     * 根据集中器id假删除进线信息
     * @param concentratorId 集中器id
     */
    void fakeDelete(Integer concentratorId);

    /**
     * 根据编号查找
     * @param concentratorId 集中器id
     * @param no 输出编号
     * @return
     */
    IotConcentratorLineOut findByNo(@Param("concentratorId") Integer concentratorId, @Param("no") Integer no);
}