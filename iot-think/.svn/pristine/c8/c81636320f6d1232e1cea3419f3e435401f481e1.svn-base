package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotAreaInfo;

import java.util.List;

public interface IotAreaInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IotAreaInfo record);

    int insertSelective(IotAreaInfo record);

    IotAreaInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IotAreaInfo record);

    int updateByPrimaryKey(IotAreaInfo record);

    /**
     * 查询所有的省
     * @return
     */
    List<IotAreaInfo> findAllProvince();

    /**
     * 根据省查询所有的市
     * @param provinceId 省id
     * @return
     */
    List<IotAreaInfo> findCityByProvinceId(Integer provinceId);

    /**
     * 根据市查询所有的区
     * @param cityId 市id
     * @return
     */
    List<IotAreaInfo> findDistrictByCityId(Integer cityId);
}