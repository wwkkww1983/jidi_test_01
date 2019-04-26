package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotSingleLightControllerFault;
import org.apache.ibatis.annotations.Param;

public interface IotSingleLightControllerFaultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotSingleLightControllerFault record);

    int insertSelective(IotSingleLightControllerFault record);

    IotSingleLightControllerFault selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotSingleLightControllerFault record);

    int updateByPrimaryKey(IotSingleLightControllerFault record);

    /**
     * 根据故障类型查找记录
     * @param type 故障类型
     * @param slcId 单灯控制器id
     * @return
     */
    IotSingleLightControllerFault findByType(@Param("type") String type, @Param("slcId") Integer slcId);
}