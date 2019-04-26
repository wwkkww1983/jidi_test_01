package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotAreaRel;
import org.apache.ibatis.annotations.Param;

public interface IotAreaRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAreaRel record);

    int insertSelective(IotAreaRel record);

    IotAreaRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAreaRel record);

    int updateByPrimaryKey(IotAreaRel record);

    /**
     * 根据省市区id来检查数据库中是否存在这条记录
     * @param iotAreaRel
     * @return
     */
    IotAreaRel isExists(@Param("iotAreaRel") IotAreaRel iotAreaRel);
}