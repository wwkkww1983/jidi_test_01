package com.rz.iot.think.mapper;

import com.rz.iot.think.model.SysUserOrgRel;

public interface SysUserOrgRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserOrgRel record);

    int insertSelective(SysUserOrgRel record);

    SysUserOrgRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserOrgRel record);

    int updateByPrimaryKey(SysUserOrgRel record);

    /**
     * 根据组织id删除组织用户关联关系
     * @param orgId
     */
    void delByOrgId(Integer orgId);

    /**
     * 根据用户id删除组织用户关联关系
     * @param userId
     */
    void delByUserId(Integer userId);
}