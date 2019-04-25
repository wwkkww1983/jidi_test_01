package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysMenu;
import com.rz.iot.think.model.param.PermissionDataEditParam;
import com.rz.iot.think.model.param.PermissionMenuEditParam;
import com.rz.iot.think.model.show.PermissionShowDataList;
import com.rz.iot.think.model.show.UserManagerShowList;

public interface PermissionService {

    /**
     * 查询用户列表
     * @param page
     * @param userManagerShowList
     * @return
     */
    Result findUserList(Page<UserManagerShowList> page, UserManagerShowList userManagerShowList);

    /**
     * 查询用户拥有的菜单权限
     * @param page
     * @param userId
     * @return
     */
    Result menuOwned(Page<SysMenu> page, Integer userId);

    /**
     * 查询用户未拥有的菜单权限
     * @param page
     * @param userId
     * @return
     */
    Result menuNotOwned(Page<SysMenu> page, Integer userId);

    /**
     * 为用户添加菜单权限
     * @param param
     * @return
     */
    Result addMenu(PermissionMenuEditParam param);

    /**
     * 删除用户菜单权限
     * @param param
     * @return
     */
    Result delMenu(PermissionMenuEditParam param);

    /**
     * 查询用户拥有的数据权限
     * @param page
     * @param userId
     * @return
     */
    Result dataOwned(Page<PermissionShowDataList> page, Integer userId, Integer businessType);

    /**
     * 查询用户没有的数据权限
     * @param page
     * @param userId
     * @param businessType
     * @return
     */
    Result dataNotOwned(Page<PermissionShowDataList> page, Integer userId, Integer businessType);

    /**
     * 给用户添加数据权限
     * @param param
     * @return
     */
    Result addData(PermissionDataEditParam param);

    /**
     * 删除用户数据权限
     * @param param
     * @return
     */
    Result delData(PermissionDataEditParam param);

}