package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysMenu;
import com.rz.iot.think.model.param.PermissionDataEditParam;
import com.rz.iot.think.model.param.PermissionMenuEditParam;
import com.rz.iot.think.model.show.PermissionShowDataList;
import com.rz.iot.think.model.show.UserManagerShowList;
import com.rz.iot.think.service.PermissionService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author by xuxiake zhangxd, Date on 2019/3/23.
 * PS: Not easy to write code, please indicate.
 * Description：管理用户菜单和数据权限
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /**
     * 查询所有用户列表
     * @param
     * @return
     */
    @RequestMapping("/findUserList")
    public Result findUserList(Page<UserManagerShowList> page, UserManagerShowList userManagerShowList){
        return permissionService.findUserList(page,userManagerShowList);
    }

    /**
     * 查询用户已拥有菜单权限
     * @param page
     * @param userId
     * @return
     */
    @RequestMapping("/menuOwned")
    public Result menuOwned(Page<SysMenu> page, Integer userId){
        return permissionService.menuOwned(page,userId);
    }

    /**
     * 查询用户未拥有菜单权限
     * @param page
     * @param userId
     * @return
     */
    @RequestMapping("/menuNotOwned")
    public Result menuNotOwned(Page<SysMenu> page, Integer userId){
        return permissionService.menuNotOwned(page,userId);
    }

    /**
     * 添加用户的菜单权限
     * @param
     * @return
     */
    @RequestMapping("/addMenu")
    @RequiresPermissions("systemPermission:addMenu")
    public Result addMenu(@RequestBody PermissionMenuEditParam param){
        return permissionService.addMenu(param);
    }

    /**
     * 删除用户的菜单权限
     * @param
     * @return
     */
    @RequestMapping("/delMenu")
    @RequiresPermissions("systemPermission:delMenu")
    public Result delMenu(@RequestBody PermissionMenuEditParam param) {
        return permissionService.delMenu(param);
    }

    /**
     * 查询用户已拥有数据权限
     * @param page
     * @param userId
     * @param businessType
     * @return
     */
    @RequestMapping("/dataOwned")
    @RequiresPermissions("systemPermission:dataOwned")
    public Result dataOwned(Page<PermissionShowDataList> page, Integer userId, Integer businessType){
        businessType = RzIotDBConstParam.USER_STATUS_OF_NORMAL;
        return permissionService.dataOwned(page,userId,businessType);
    }

    /**
     * 查询用户未拥有数据权限
     * @param page
     * @param userId
     * @param businessType
     * @return
     */
    @RequestMapping("/dataNotOwned")
    @RequiresPermissions("systemPermission:dataNotOwned")
    public Result dataNotOwned(Page<PermissionShowDataList> page, Integer userId, Integer businessType){
        businessType = RzIotDBConstParam.USER_STATUS_OF_NORMAL;
        return permissionService.dataNotOwned(page,userId,businessType);
    }

    /**
     * 添加用户的数据权限
     * @param param
     * @return
     */
    @RequestMapping("/addData")
    @RequiresPermissions("systemPermission:addData")
    public Result addData(@RequestBody PermissionDataEditParam param){
        return permissionService.addData(param);
    }

    /**
     * 删除用户的数据权限
     * @param param
     * @return
     */
    @RequestMapping("/delData")
    @RequiresPermissions("systemPermission:delData")
    public Result delData(@RequestBody PermissionDataEditParam param){
        return permissionService.delData(param);
    }
}