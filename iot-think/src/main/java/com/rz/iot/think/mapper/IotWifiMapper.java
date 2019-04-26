package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotWifi;
import com.rz.iot.think.model.show.IotStreetlightInstallDevForNoBinding;
import com.rz.iot.think.model.show.IotStreetlightInstallDevShowDetail;

import java.util.List;

public interface IotWifiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotWifi record);

    int insertSelective(IotWifi record);

    IotWifi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotWifi record);

    int updateByPrimaryKey(IotWifi record);

    /**
     * 查找未与路灯绑定的wifi
     * @return
     */
    List<IotStreetlightInstallDevForNoBinding> findNoBinding();

    /**
     * wifi详情（路灯管理）
     * @param wifiId wifi id
     * @return
     */
    IotStreetlightInstallDevShowDetail detailForStreetLight(Integer wifiId);
}