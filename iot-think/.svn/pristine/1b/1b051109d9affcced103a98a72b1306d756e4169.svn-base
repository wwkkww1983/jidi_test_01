package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotConcentratorGroupAddParam;
import com.rz.iot.think.model.param.IotConcentratorGroupDelParam;
import com.rz.iot.think.model.param.IotConcentratorListQueryParam;
import com.rz.iot.think.service.IotConcentratorGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 * Description：集中器组
 */
@RestController
@RequestMapping("/concentratorGroup")
public class IotConcentratorGroupController {

    @Resource
    private IotConcentratorGroupService iotConcentratorGroupService;

    /**
     * 查询集中器组列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(Page page, IotConcentratorListQueryParam param) {
        return iotConcentratorGroupService.findAll(page, param);
    }

    /**
     * 集中器组详情
     * @param groupId 集中器组id
     * @return
     */
    @RequestMapping("/detail")
    public Result detail(Integer groupId) {
        return iotConcentratorGroupService.detail(groupId);
    }

    /**
     * 增加集中器组
     * @param param
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody IotConcentratorGroupAddParam param) {
        return iotConcentratorGroupService.add(param);
    }

    /**
     * 更新集中器组
     * @param param
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody IotConcentratorGroupAddParam param) {
        return iotConcentratorGroupService.update(param);
    }

    /**
     * 删除集中器组
     * @param param
     * @return
     */
    @RequestMapping("/del")
    public Result del(@RequestBody IotConcentratorGroupDelParam param) {
        return iotConcentratorGroupService.del(param.getGroupIds());
    }
}
