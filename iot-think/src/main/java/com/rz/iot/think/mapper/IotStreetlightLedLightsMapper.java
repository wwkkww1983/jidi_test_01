package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotStreetlightLedLights;
import com.rz.iot.think.model.show.IotStreetlightLedLightsShowDetail;

import java.util.List;

public interface IotStreetlightLedLightsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotStreetlightLedLights record);

    int insertSelective(IotStreetlightLedLights record);

    IotStreetlightLedLights selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotStreetlightLedLights record);

    int updateByPrimaryKey(IotStreetlightLedLights record);

    /**
     * 根据路灯ID查询路灯上所有led
     * @param streetLightId
     * @return
     */
    List<IotStreetlightLedLights> findByStreetlightId(Integer streetLightId);

    /**
     * 批量插入，并返回主键
     * @param list
     */
    void insertBatch(List<IotStreetlightLedLights> list);

    /**
     * 根据路灯id删除
     * @param streetlightId
     */
    void delByStreetlightId(Integer streetlightId);

    /**
     * led详情
     * @param ledId led id
     * @return
     */
    IotStreetlightLedLightsShowDetail detail(Integer ledId);
}