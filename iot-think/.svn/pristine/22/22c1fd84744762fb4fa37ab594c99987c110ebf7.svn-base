package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotAreaCityRoad;

import java.util.List;

public interface IotAreaCityRoadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAreaCityRoad record);

    int insertSelective(IotAreaCityRoad record);

    IotAreaCityRoad selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAreaCityRoad record);

    int updateByPrimaryKey(IotAreaCityRoad record);

    /**
     * 根据区id查找路
     * @param streetId 街道id
     * @return
     */
    List<IotAreaCityRoad> findByDistrictId(Integer streetId);
}