package com.rz.iot.think.mapper;

import com.rz.iot.think.model.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    /**
     * 根据用户id查找该用户所有的菜单权限
     * @param userId
     * @return
     */
    List<SysMenu> findAllMenuByUserId(Integer userId);

    /**
     * 根据用户id查找该用户未拥有的菜单权限
     * @param userId
     * @return
     */
    List<SysMenu> menuNotOwned(Integer userId);
}