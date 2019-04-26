package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotSingleLightControllerLedLightsRel;

import java.util.List;

public interface IotSingleLightControllerLedLightsRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotSingleLightControllerLedLightsRel record);

    int insertSelective(IotSingleLightControllerLedLightsRel record);

    IotSingleLightControllerLedLightsRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotSingleLightControllerLedLightsRel record);

    int updateByPrimaryKey(IotSingleLightControllerLedLightsRel record);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotSingleLightControllerLedLightsRel> list);

    /**
     * 根据路灯ID删除
     * @param streetlightId
     */
    void delByStreetlightId(Integer streetlightId);
}