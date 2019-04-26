package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotChargingPoint;
import com.rz.iot.think.model.show.IotStreetlightInstallDevForNoBinding;
import com.rz.iot.think.model.show.IotStreetlightInstallDevShowDetail;

import java.util.List;

public interface IotChargingPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotChargingPoint record);

    int insertSelective(IotChargingPoint record);

    IotChargingPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotChargingPoint record);

    int updateByPrimaryKey(IotChargingPoint record);

    /**
     * 充电桩详情（路灯管理）
     * @param chargingPointId 充电桩id
     * @return
     */
    IotStreetlightInstallDevShowDetail detailForStreetLight(Integer chargingPointId);

    /**
     * 查找未与路灯绑定的充电桩
     * @return
     */
    List<IotStreetlightInstallDevForNoBinding> findNoBinding();
}