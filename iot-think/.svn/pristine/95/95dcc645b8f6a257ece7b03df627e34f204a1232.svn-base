package com.rz.iot.think.mapper;

import com.rz.iot.think.model.SysUserMenuRel;
import com.rz.iot.think.model.param.PermissionMenuEditParam;
import org.apache.ibatis.annotations.Param;

public interface SysUserMenuRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserMenuRel record);

    int insertSelective(SysUserMenuRel record);

    SysUserMenuRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserMenuRel record);

    int updateByPrimaryKey(SysUserMenuRel record);

    /**
     * 根据用户id和menuId删除一条记录
     * @param userId
     * @param menuId
     */
    void delByUserIdAndMenuId(@Param("userId") Integer userId, @Param("menuId") Integer menuId);

    /**
     * 批量插入
     * @param param
     */
    void insertBatch(@Param("param") PermissionMenuEditParam param);

    /**
     * 批量删除
     * @param param
     */
    void delBatch(@Param("param") PermissionMenuEditParam param);
}