package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.UserManagerParam;
import com.rz.iot.think.model.show.UserManagerShowList;
import com.rz.iot.think.service.UserManagerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/userManager")
public class UserManagerController {

    @Resource
    private UserManagerService userManagerService;

    /**
     * 查找所有的用户
     * @return
     */
    @RequestMapping("/findAll")
    @RequiresPermissions("systemUser:findAll")
    public Result findAll(Page<UserManagerShowList> page, UserManagerShowList userManagerShowList) {
        return userManagerService.findAll(page, userManagerShowList);
    }

    /**
     * 用户详情
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/detail")
    @RequiresPermissions("systemUser:detail")
    public Result detail(Integer userId) {
        return userManagerService.detail(userId);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping("/add")
    @RequiresPermissions("systemUser:add")
    public Result add(@RequestBody UserManagerParam user) {
        return userManagerService.add(user);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("systemUser:update")
    public Result update(@RequestBody UserManagerParam user) {
        return userManagerService.update(user);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/del")
    @RequiresPermissions("systemUser:del")
    public Result del(Integer userId) {
        return userManagerService.del(userId);
    }

    /**
     * 上传头像
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/avatarUpload")
    public Result avatarUpload(MultipartFile file, HttpServletRequest request) {
        return userManagerService.avatarUpload(file, request);
    }
}