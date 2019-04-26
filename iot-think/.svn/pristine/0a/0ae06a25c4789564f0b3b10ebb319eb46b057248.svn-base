package com.rz.iot.think.mapper;

import com.rz.iot.think.model.SysOrganization;
import com.rz.iot.think.model.show.IotRoleSettingOrganizationShowDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);

    /**
     * 查找所有组织
     * @return
     */
    List<IotRoleSettingOrganizationShowDetail> findAll(@Param("iotRoleSettingOrganizationShowDetail") IotRoleSettingOrganizationShowDetail iotRoleSettingOrganizationShowDetail);

}